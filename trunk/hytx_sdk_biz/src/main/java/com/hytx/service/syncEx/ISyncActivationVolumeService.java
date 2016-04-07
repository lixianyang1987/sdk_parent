package com.hytx.service.syncEx;

import java.util.List;

import com.hytx.model.syncEx.TActivationVolume;
import com.hytx.util.Page;

public interface ISyncActivationVolumeService {
	public int addActivationVolume(List<TActivationVolume> aclist);
	
	public List<TActivationVolume> selectTActivationVolumeList(TActivationVolume ta,Page<TActivationVolume> page);
}
