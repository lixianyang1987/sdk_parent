package com.hytx.service.baseConf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.baseConf.ex.OperateMapperEx;
import com.hytx.dao.baseConf.ori.OperateMapper;
import com.hytx.dao.baseConf.ori.ProvinceRefMapper;
import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateExample;
import com.hytx.model.baseConf.ProvinceRefExample;
import com.hytx.util.Page;

@Service("operateServiceImpl")
public class OperateServiceImpl implements IOperateService {
	@Autowired
	private OperateMapper operateMapper;
	@Autowired
	private OperateMapperEx operateMapperEx;
	@Autowired
	private ProvinceRefMapper provinceRefMapper;
	@Autowired
	private IPayPointService payPointService;

	@Override
	@Transactional(readOnly = true)
	public List<Operate> selectOperatesByPage(OperateDto findOperate,
			Page<Operate> page) {
		List<Operate> resultList = operateMapperEx.selectOperateListByPage(
				findOperate, page);
		page.setResultList(resultList);
		page.setTotalCount(operateMapperEx.countOperate(findOperate));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(Operate operate) {
		return operateMapper.insert(operate);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKey(Operate operate) {
		Operate permOperate = operateMapper.selectByPrimaryKey(operate.getId());
		operate.setCreateBy(permOperate.getCreateBy());
		operate.setCreateDt(permOperate.getCreateDt());
		if (operate.getStatus() < BaseContance.ACTIVICE_STATUS
				&& permOperate.getStatus().equals(BaseContance.ACTIVICE_STATUS)) {
			/*	payPointService
						.deletePayPointByOpIds(Arrays.asList(operate.getId()));*/
			payPointService.updatePayPointStatusByOpIds(
					Arrays.asList(operate.getId()),
					BaseContance.NOT_ACTIVICE_STATUS);
		}
		return operateMapper.updateByPrimaryKeySelective(operate);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteOperateByIds(List<Integer> idList) {
		OperateExample example = new OperateExample();
		example.createCriteria().andIdIn(idList);
		int rows = operateMapper.deleteByExample(example);
		ProvinceRefExample refExample = new ProvinceRefExample();
		// 删除关联的指令省份
		refExample.createCriteria().andRecordIdIn(idList)
				.andRefTypeEqualTo(BaseContance.PROVINCE_REF_TYPE_OPERATE);
		provinceRefMapper.deleteByExample(refExample);
		// 删除关联的计费点及计费点指令
		payPointService.deletePayPointByOpIds(idList);
		return rows;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteOperateByAppIds(List<Integer> idList) {
		OperateExample example = new OperateExample();
		example.createCriteria().andAppIdIn(idList);
		List<Operate> list = operateMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return 0;
		}
		List<Integer> ids = new ArrayList<Integer>();
		for (Operate op : list) {
			ids.add(op.getId());
		}
		return deleteOperateByIds(ids);
	}

	@Override
	public Operate selectByPrimaryKey(Integer id) {
		return operateMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Operate> selectReqSmsOperate(Integer serverType, Integer appId) {
		return operateMapperEx.selectServerAppOperates(serverType, appId);
	}

	@Cacheable(value = "selectOperateByPayPointIds", key = "'selectOperateByPayPointIds_'+#payPointId")
	public List<Operate> selectOperateByPayPointIds(Integer payPointId) {
		return operateMapperEx.selectOperateByPayPointIds(payPointId);
	}

	@Override
	@Cacheable(value = "selectActivityOperatesByAppId", key = "'selectActivityOperatesByAppId_'+#appId+'_'+#serverType")
	public List<Operate> selectActivityOperatesByAppId(Integer appId,
			Integer serverType) {
		OperateExample example = new OperateExample();
		example.createCriteria().andAppIdEqualTo(appId)
				.andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andServerTypeEqualTo(serverType);
		List<Operate> list = operateMapper.selectByExample(example);
		return list;
	}

}
