package com.hytx.service.xzf;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.constance.XzfConstant;
import com.hytx.dao.xzf.ori.XzfWxBillMapper;
import com.hytx.dao.xzf.ori.XzfWxBillResultMapper;
import com.hytx.dto.xzf.WxPayAppPayDto;
import com.hytx.dto.xzf.WxPayQueryReqDto;
import com.hytx.dto.xzf.WxPayQueryRespDto;
import com.hytx.dto.xzf.WxPayReqDto;
import com.hytx.dto.xzf.WxPayRespDto;
import com.hytx.model.xzf.XzfWxBill;
import com.hytx.model.xzf.XzfWxBillResult;
import com.hytx.model.xzf.XzfWxBillResultExample;
import com.hytx.util.CopyUtil;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.JaxbUtil;

@Service("wxPayServiceImpl")
public class WxPayServiceImpl implements IWxPayService {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	private XzfWxBillMapper xzfWxBillMapper;
	@Autowired
	private XzfWxBillResultMapper xzfWxBillResultMapper;
	@Autowired
	private IXzfUserService xzfUserService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertXzfWxBill(XzfWxBill record) {
		if (record.getOrderId() == null) {
			return 0;
		}
		XzfWxBill entity = xzfWxBillMapper.selectByPrimaryKey(record
				.getOrderId());
		if (entity == null) {
			xzfWxBillMapper.insert(record);
		}
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertXzfWxBillResult(XzfWxBillResult record) {
		if (record.getOrderId() == null) {
			return 0;
		}
		XzfWxBill entity = xzfWxBillMapper.selectByPrimaryKey(record
				.getTransactionId());
		if (entity == null) {
			xzfWxBillResultMapper.insert(record);
			XzfWxBill wxBill = new XzfWxBill();
			wxBill.setOrderId(record.getOrderId());
			wxBill.setStep(2);
			if ("SUCCESS".equals(record.getResultCode())) {
				wxBill.setStatus(BaseContance.ACTIVICE_STATUS);
				if (wxBill.getOpType() == 2) {
					xzfUserService.repayment(wxBill.getImei(),
							wxBill.getFeeValue());
				} else {
					xzfUserService.thirdPayCallBack(wxBill.getImei(),
							wxBill.getFeeValue());
				}
			}
			xzfWxBillMapper.updateByPrimaryKeySelective(wxBill);
		}
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateXzfWxBillByOrderIdSelective(XzfWxBill record) {
		return xzfWxBillMapper.updateByPrimaryKeySelective(record);
	}

	/***
	 * 微信支付接口服务器端统一下单
	 * 
	 * @param reqDto
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	@Override
	public WxPayAppPayDto unionPay(WxPayReqDto reqDto) {
		String data = JaxbUtil.convertToXml(reqDto);
		try {
			String response = HttpClientUtil.postXmlData(
					XzfConstant.WX_UNION_PAY_URL, data);
			if (response == null) {
				return null;
			}
			WxPayRespDto respDto = JaxbUtil.converyToJavaBean(response,
					WxPayRespDto.class);
			logger.info("统一下单返回数据为:\n{}", response);
			if (!respDto.valid()) {
				logger.info("统一下单返回数据验证失败");
				return null;
			}
			if ("SUCCESS".equals(respDto.getReturnCode())) {
				logger.info("统一下单请求成功");
				if ("SUCCESS".equals(respDto.getResultCode())) {
					logger.info("统一下单订单处理成功");
					WxPayAppPayDto appPayDto = new WxPayAppPayDto(respDto);
					return appPayDto;
				} else {
					logger.info("统一下单订单处理失败,失败信息为:/n{}/n{}/n{}",
							respDto.getReturnMsg(), respDto.getErrCode(),
							respDto.getErrCodeDes());
				}
			} else {
				logger.info("统一下单请求失败");
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****
	 * 查询微信订单状态
	 * 
	 * @param orderId
	 * @return
	 * @author houzz
	 * @date 2016年1月7日
	 */
	@Override
	public String wxPayQuery(String orderId) {
		WxPayQueryReqDto queryReqDto = new WxPayQueryReqDto(orderId);
		String data = JaxbUtil.convertToXml(queryReqDto);
		try {
			String response = HttpClientUtil.postXmlData(
					XzfConstant.WX_ORDER_QUERY_URL, data);
			if (response == null) {
				return null;
			}
			WxPayQueryRespDto respDto = JaxbUtil.converyToJavaBean(response,
					WxPayQueryRespDto.class);
			logger.info("查询微信支付订单状态返回数据为:\n{}", response);
			if (!respDto.valid()) {
				logger.info("查询微信支付订单状态返回数据验证失败");
				return null;
			}
			if ("SUCCESS".equals(respDto.getReturnCode())) {
				if ("SUCCESS".equals(respDto.getResultCode())) {
					String tradeState = respDto.getTradeState();
					if (!"USERPAYING".equals(tradeState)) {
						XzfWxBillResult wxBillResult = new XzfWxBillResult();
						CopyUtil.copy(respDto, wxBillResult);
						wxBillResult.setCreateDt(new Date());
						insertXzfWxBillResult(wxBillResult);
					}
					return tradeState;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public XzfWxBillResult selectWxBillResult(String orderId) {
		XzfWxBillResultExample example = new XzfWxBillResultExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		example.setOrderByClause("create_dt desc");
		List<XzfWxBillResult> list = xzfWxBillResultMapper
				.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
