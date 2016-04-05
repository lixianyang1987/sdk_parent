package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.CpInfo;
import com.hytx.util.Page;

public interface CpInfoMapperEx {
	
	public List<CpInfo>selectCpInfoListByPage(@Param("findCpInfo")CpInfo findCpInfo,@Param("page")Page<CpInfo>page);
	
	public int countCpInfo(@Param("findCpInfo")CpInfo findCpInfo);
}