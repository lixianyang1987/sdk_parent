package com.hytx.service.baseConf;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.baseConf.ex.ChannelAppMapperEx;
import com.hytx.dao.baseConf.ex.ProvinceMapperEx;
import com.hytx.dao.baseConf.ori.ProvinceMapper;
import com.hytx.dao.baseConf.ori.ProvinceRefMapper;
import com.hytx.dto.baseConf.ProvinceDto;
import com.hytx.model.baseConf.Province;
import com.hytx.model.baseConf.ProvinceExample;
import com.hytx.model.baseConf.ProvinceRef;
import com.hytx.model.baseConf.ProvinceRefExample;
import com.hytx.model.baseConf.ProvinceRefExample.Criteria;
import com.hytx.model.system.User;
import com.hytx.util.Page;

@Service("provinceServiceImpl")
public class ProvinceServiceImpl implements IProvinceService {
	@Autowired
	private ProvinceMapper provinceMapper;
	@Autowired
	private ProvinceMapperEx provinceMapperEx;
	@Autowired
	private ProvinceRefMapper provinceRefMapper;
	@Autowired
	private ChannelAppMapperEx channelAppMapperEx;

	@Override
	@Transactional(readOnly = true)
	public List<Province> selectProvincesByPage(Province findProvince,
			Page<Province> page) {
		List<Province> resultList = provinceMapperEx.selectProvinceListByPage(
				findProvince, page);
		page.setResultList(resultList);
		page.setTotalCount(provinceMapperEx.countProvince(findProvince));
		return resultList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(Province province) {
		return provinceMapper.insert(province);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(Province province) {
		if (province.getProvinceName() == null) {
			province.setProvinceName("");
		}
		return provinceMapper.updateByPrimaryKeySelective(province);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteProvinceByIds(List<Integer> idList) {
		ProvinceExample example = new ProvinceExample();
		example.createCriteria().andIdIn(idList);
		int rows = provinceMapper.deleteByExample(example);
		// 删除关联的数据
		ProvinceRefExample refExample = new ProvinceRefExample();
		refExample.createCriteria().andProvinceIdIn(idList);
		provinceRefMapper.deleteByExample(refExample);
		return rows;
	}

	public int deleteProvinceRefByRecordIdsAndType(List<Integer> idList,
			Integer refType) {
		ProvinceRefExample refExample = new ProvinceRefExample();
		refExample.createCriteria().andRecordIdIn(idList)
				.andRefTypeEqualTo(refType);
		return provinceRefMapper.deleteByExample(refExample);
	}

	@Override
	public Province selectByPrimaryKey(Integer id) {
		return provinceMapper.selectByPrimaryKey(id);
	}

	public List<Province> selectAllActiveProvince() {
		ProvinceExample example = new ProvinceExample();
		return provinceMapper.selectByExample(example);
	}

	public List<ProvinceDto> selectChannelAppProvinceDtoList(Integer recordId) {
		return provinceMapperEx.selectChannelAppProvinceDtoList(recordId);
	}

	public List<ProvinceDto> selectAppProvinceDtoList(Integer recordId) {
		return provinceMapperEx.selectAppProvinceDtoList(recordId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int insertChannelAppProvinceRefs(Integer ids[], Long limits[],
			Integer recordId, User userSession) {
		if (ids == null) {
			ids = new Integer[0];
		}
		if (limits == null) {
			limits = new Long[0];
		}
		if (ids.length != limits.length) {
			return 0;
		}
		ProvinceRefExample example = new ProvinceRefExample();
		Criteria cretiria = example.createCriteria();
		cretiria.andRefTypeEqualTo(BaseContance.PROVINCE_REF_TYPE_CHANNEL_APP)
				.andRecordIdEqualTo(recordId);
		// 查询当前存在的记录
		List<ProvinceRef> list = provinceRefMapper.selectByExample(example);
		// 如果没有新设置省份或者没有移除省份，则不做处理
		if (ids.length == 0 && (list == null || list.isEmpty())) {
			return 0;
		}
		// 将页面输入的省份id数组转成list
		List<Integer> idList = Arrays.asList(ids);
		// 如果没有新设置省份或者没有移除省份，则不做处理
		if (idList.size() == list.size() && idList.containsAll(list)) {
			return 0;
		}
		// 删除此指渠道包所有关联省份的数据
		ProvinceRefExample exampleDel = new ProvinceRefExample();
		exampleDel.createCriteria()
				.andRefTypeEqualTo(BaseContance.PROVINCE_REF_TYPE_CHANNEL_APP)
				.andRecordIdEqualTo(recordId);
		provinceRefMapper.deleteByExample(exampleDel);
		// 添加新增省份记录
		for (int i = 0; i < ids.length; i++) {
			ProvinceRef ref = new ProvinceRef();
			ref.setProvinceId(ids[i]);
			ref.setRecordId(recordId);
			ref.setRefType(BaseContance.PROVINCE_REF_TYPE_CHANNEL_APP);
			ref.setCreateBy(userSession.getUserName());
			ref.setCreateDt(new Date());
			ref.setDayLimit(limits[i]);
			provinceRefMapper.insert(ref);
		}
		return ids.length;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int insertAppProvinceRefs(Integer ids[], Long limits[],
			Integer recordId, User userSession) {
		if (ids == null) {
			ids = new Integer[0];
		}
		if (limits == null) {
			limits = new Long[0];
		}
		if (ids.length != limits.length) {
			return 0;
		}
		ProvinceRefExample example = new ProvinceRefExample();
		Criteria cretiria = example.createCriteria();
		cretiria.andRefTypeEqualTo(BaseContance.PROVINCE_REF_TYPE_APP)
				.andRecordIdEqualTo(recordId);
		// 查询当前存在的记录
		List<ProvinceRef> list = provinceRefMapper.selectByExample(example);
		// 如果没有新设置省份或者没有移除省份，则不做处理
		if (ids.length == 0 && (list == null || list.isEmpty())) {
			return 0;
		}
		// 将页面输入的省份id数组转成list
		List<Integer> idList = Arrays.asList(ids);
		// 如果没有新设置省份或者没有移除省份，则不做处理
		if (idList.size() == list.size() && idList.containsAll(list)) {
			return 0;
		}
		// 删除此指应用所有关联省份的数据
		ProvinceRefExample exampleDel = new ProvinceRefExample();
		exampleDel.createCriteria()
				.andRefTypeEqualTo(BaseContance.PROVINCE_REF_TYPE_APP)
				.andRecordIdEqualTo(recordId);
		provinceRefMapper.deleteByExample(exampleDel);
		// 添加新增省份记录
		for (int i = 0; i < ids.length; i++) {
			ProvinceRef ref = new ProvinceRef();
			ref.setProvinceId(ids[i]);
			ref.setRecordId(recordId);
			ref.setRefType(BaseContance.PROVINCE_REF_TYPE_APP);
			ref.setCreateBy(userSession.getUserName());
			ref.setCreateDt(new Date());
			ref.setDayLimit(limits[i]);
			provinceRefMapper.insert(ref);
		}
		return ids.length;
	}

	@Cacheable(value = "findProvinceByName", key = "'findProvinceByName_'+#name")
	public Province findProvinceByName(String name) {
		ProvinceExample example = new ProvinceExample();
		example.createCriteria().andProvinceNameEqualTo(name);
		List<Province> list = provinceMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
