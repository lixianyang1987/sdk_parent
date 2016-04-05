package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.AppServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppServerMapper {
    int countByExample(AppServerExample example);

    int deleteByExample(AppServerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppServer record);

    int insertSelective(AppServer record);

    List<AppServer> selectByExample(AppServerExample example);

    AppServer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppServer record, @Param("example") AppServerExample example);

    int updateByExample(@Param("record") AppServer record, @Param("example") AppServerExample example);

    int updateByPrimaryKeySelective(AppServer record);

    int updateByPrimaryKey(AppServer record);
}