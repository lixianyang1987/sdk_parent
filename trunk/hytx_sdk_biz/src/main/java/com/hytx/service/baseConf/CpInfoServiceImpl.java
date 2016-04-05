package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.CpInfoMapperEx;
import com.hytx.dao.baseConf.ori.CpInfoMapper;
import com.hytx.model.baseConf.CpInfo;
import com.hytx.model.baseConf.CpInfoExample;
import com.hytx.util.Page;

@Service("cpInfoServiceImpl")
public class CpInfoServiceImpl implements ICpInfoService {
	@Autowired
	private CpInfoMapper cpInfoMapper;
	@Autowired
	private CpInfoMapperEx cpInfoMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<CpInfo> selectCpInfosByPage(CpInfo findCpInfo, Page<CpInfo> page) {
		List<CpInfo> resultList = cpInfoMapperEx
				.selectCpInfoListByPage(findCpInfo, page);
		page.setResultList(resultList);
		page.setTotalCount(cpInfoMapperEx.countCpInfo(findCpInfo));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(CpInfo cpInfo) {
		return cpInfoMapper.insert(cpInfo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKey(CpInfo cpInfo) {
		if (cpInfo.getCpName() == null) {
			cpInfo.setCpName("");
		}
		return cpInfoMapper.updateByPrimaryKeySelective(cpInfo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteCpInfoByIds(List<Integer> idList) {
		CpInfoExample example = new CpInfoExample();
		example.createCriteria().andIdIn(idList);
		return cpInfoMapper.deleteByExample(example);
	}

	@Override
	public CpInfo selectByPrimaryKey(Integer id) {
		return cpInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CpInfo> selectAllActiveCpInfos() {
		CpInfoExample example = new CpInfoExample();
		example.createCriteria().andStatusEqualTo(EnumStatus.ok.getValue());
		return cpInfoMapper.selectByExample(example);
	}

}
