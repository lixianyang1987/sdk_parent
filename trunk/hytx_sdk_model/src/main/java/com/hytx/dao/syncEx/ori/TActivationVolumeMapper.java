package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.TActivationVolume;
import com.hytx.model.syncEx.TActivationVolumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActivationVolumeMapper {
    int countByExample(TActivationVolumeExample example);

    int deleteByExample(TActivationVolumeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TActivationVolume record);

    int insertSelective(TActivationVolume record);

    List<TActivationVolume> selectByExample(TActivationVolumeExample example);

    TActivationVolume selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TActivationVolume record, @Param("example") TActivationVolumeExample example);

    int updateByExample(@Param("record") TActivationVolume record, @Param("example") TActivationVolumeExample example);

    int updateByPrimaryKeySelective(TActivationVolume record);

    int updateByPrimaryKey(TActivationVolume record);
}