package com.hytx.service.xzf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.xzf.ori.XzfYijieBillMapper;
import com.hytx.dao.xzf.ori.XzfYijieResultMapper;
import com.hytx.model.xzf.XzfYijieBill;
import com.hytx.model.xzf.XzfYijieResult;
import com.hytx.util.HttpClientUtil;

@Service("yijiePayServiceImpl")
public class YijiePayServiceImpl implements IYijiePayService {
	private static final String YIJIE_LOGIN_URI = "http://sync.1sdk.cn/login/check.html";
	private static final String SDK = "B101363CA00933D2";
	private static final String APP = "28BCD14771D67E2C";

	@Autowired
	private XzfYijieBillMapper xzfYijieBillMapper;
	@Autowired
	private XzfYijieResultMapper xzfYijieResultMapper;
	@Autowired
	private IXzfUserService xzfUserService;

	@Override
	@Transactional
	public int insertYijieBill(XzfYijieBill yijieBill) {
		XzfYijieBill record = xzfYijieBillMapper.selectByPrimaryKey(yijieBill
				.getOrderId());
		if (record != null) {
			return 1;
		}
		return xzfYijieBillMapper.insert(yijieBill);
	}

	@Override
	@Transactional
	public int insertYijieResult(XzfYijieResult yijieResult) {
		XzfYijieResult record = xzfYijieResultMapper
				.selectByPrimaryKey(yijieResult.getTcd());
		if (record != null) {
			return 1;
		}
		xzfYijieResultMapper.insert(yijieResult);
		if (yijieResult.getStatus() != null && yijieResult.getStatus() == 1) {
			XzfYijieBill bill = xzfYijieBillMapper
					.selectByPrimaryKey(yijieResult.getOrderId());
			if (bill != null) {
				bill.setStep(2);
				bill.setStatus(BaseContance.ACTIVICE_STATUS);
				xzfYijieBillMapper.updateByPrimaryKeySelective(bill);
				if (bill.getOpType() == 2) {
					xzfUserService
							.repayment(bill.getImei(), bill.getFeeValue());
				} else {
					xzfUserService.thirdPayCallBack(bill.getImei(),
							bill.getFeeValue());
				}
			}
		}
		return 1;

	}

	@Override
	public String login(String uin, String sess) {
		try {
			uin = URLEncoder.encode(uin, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder(200);
		sb.append(YIJIE_LOGIN_URI).append("?sdk=").append(SDK).append("&app=")
				.append(APP).append("&uin=").append(uin).append("&sess=")
				.append(sess);
		try {
			String response = HttpClientUtil.simpleVisitUrl(sb.toString());
			return response;
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "-1";
	}

	@Override
	public XzfYijieBill selectXzfYijieBillByOrderId(String orderId) {
		return xzfYijieBillMapper.selectByPrimaryKey(orderId);
	}
}
