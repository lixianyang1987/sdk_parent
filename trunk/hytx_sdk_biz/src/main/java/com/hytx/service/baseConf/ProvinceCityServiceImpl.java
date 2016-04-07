package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.EnumStatus;
import com.hytx.dao.baseConf.ex.ProvinceCityMapperEx;
import com.hytx.dao.baseConf.ori.ProvinceCityMapper;
import com.hytx.model.baseConf.ProvinceCity;
import com.hytx.model.baseConf.ProvinceCityExample;
import com.hytx.util.Page;

@Service("provinceCityServiceImpl")
public class ProvinceCityServiceImpl implements IProvinceCityService {
	@Autowired
	private ProvinceCityMapper provinceCityMapper;
	@Autowired
	private ProvinceCityMapperEx provinceCityMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<ProvinceCity> selectProvinceCitysByPage(ProvinceCity findProvinceCity, Page<ProvinceCity> page) {
		List<ProvinceCity> resultList = provinceCityMapperEx
				.selectProvinceCityListByPage(findProvinceCity, page);
		page.setResultList(resultList);
		page.setTotalCount(provinceCityMapperEx.countProvinceCity(findProvinceCity));
		return resultList;
	}

	public int countCitys(List<Integer>provinceIds){
		ProvinceCityExample example=new ProvinceCityExample();
		example.createCriteria().andProvinceIdIn(provinceIds);
		return provinceCityMapper.countByExample(example);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(ProvinceCity provinceCity) {
		return provinceCityMapper.insert(provinceCity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(ProvinceCity provinceCity) {
		if (provinceCity.getCityName() == null) {
			provinceCity.setCityName("");
		}
		return provinceCityMapper.updateByPrimaryKeySelective(provinceCity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteProvinceCityByIds(List<Integer> idList) {
		ProvinceCityExample example = new ProvinceCityExample();
		example.createCriteria().andIdIn(idList);
		return provinceCityMapper.deleteByExample(example);
	}

	@Override
	public ProvinceCity selectByPrimaryKey(Integer id) {
		return provinceCityMapper.selectByPrimaryKey(id);
	}

	public List<ProvinceCity>selectAllActiveProvinceCity(){
		ProvinceCityExample example = new ProvinceCityExample();
		return provinceCityMapper.selectByExample(example);
	}
}
