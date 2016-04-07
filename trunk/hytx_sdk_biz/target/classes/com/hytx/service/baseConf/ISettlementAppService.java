package com.hytx.service.baseConf;



import java.util.List;

import com.hytx.model.baseConf.SettlementApp;


public interface ISettlementAppService {
	
	public int addSmApp(SettlementApp smApp);
	
	public int updateSmApp(SettlementApp smApp);
	
	public int delSmApp(int appId);
	
	public SettlementApp selctSmApp(int appId);
	
	public int delsSmApp(List<Integer> ids) ;
	
}
