package com.hytx.service.baseConf;



import java.util.List;

import com.hytx.model.baseConf.SettlementChannelApp;


public interface ISettlementChannelAppService {
	
	public int addSmApp(SettlementChannelApp smApp);
	
	public int updateSmApp(SettlementChannelApp smApp);
	
	public int delSmApp(int appId);
	
	public SettlementChannelApp selctSmApp(int appId);
	
	public int delsSmApp(List<Integer> ids) ;
	
}
