package com.hytx.service.syncEx;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.ResourceUtil;
import com.hytx.dao.syncEx.ori.TsyncexSkyMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.syncEx.TsyncexSky;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.HttpClientUtil;
@Service("syncSkyServiceImpl")
public class SyncSkyServiceImpl implements ISyncSkyService {
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private TsyncexSkyMapper syncexSkyMapper;
	private ChannelApp channelApp;
	private Random random = new Random();
	@Override
	public String reqSms(TsyncexSky tSyncexSky) {
		// TODO Auto-generated method stub
		//=111&=13552922111&=1&=test
		try {
		int channelappId=Integer.parseInt(ResourceUtil.getChannelappId("sky"));
		channelApp=channelAppService.selectByPrimaryKey(channelappId);
		StringBuilder sb =new StringBuilder();
		tSyncexSky.setCoopId(channelApp.getChannelId());
		tSyncexSky.setChannelAppId((long)channelappId);
		Integer reducePercent = channelApp.getReducePercent();		
		tSyncexSky.setReduceStatus(0);
		if (reducePercent != null) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				tSyncexSky.setReduceStatus(1);
			}
		}
		sb.append("http://www.duolawang.com/service/yd/getpaymentcode?")
		.append("cid=").append("5")
		.append("&phoneNum=").append(tSyncexSky.getPhonenum())
		.append("&price=").append(tSyncexSky.getPrice())
		.append("&ext=").append(tSyncexSky.getExt());		
			String content = HttpClientUtil.simpleVisitUrl(sb.toString());
			if(content!=null){
				if(content.indexOf("linkid=")>-1){
					tSyncexSky.setLinkid(content.split("=")[1]);
					tSyncexSky.setCreatetime(new Date());
					syncexSkyMapper.insertSelective(tSyncexSky);
				}
				
				return content;
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	@Override
	public String reqResult(TsyncexSky tSyncexSky, String paymentCode) {
		// TODO Auto-generated method stub
		
		 TsyncexSky	syncsky=syncexSkyMapper.selectByPrimaryKey(tSyncexSky.getLinkid());
		 StringBuilder sb =new StringBuilder();
		 sb.append("http://www.duolawang.com/service/yd/paymentcharge?")
			.append("linkid=").append(tSyncexSky.getLinkid())
			.append("&paymentCode=").append(paymentCode);
		 String content;
		 String str=null;
		try {
			content = HttpClientUtil.simpleVisitUrl(sb.toString());
			if(content!=null){
				if(content.indexOf("status=")>-1){
					if(content.indexOf("@")>-1){
						String[] co= content.split("@");
						if(co[0].equals("status=0")&&syncsky.getReduceStatus()==1){
							tSyncexSky.setStatus(0);
							tSyncexSky.setExt(co[1]);
							str= content;
						}else{
							tSyncexSky.setStatus(601);
							tSyncexSky.setExt(co[1]);
							str= "status=601@"+co[1];
						}
					}else{
						if(content.equals("status=0")&&syncsky.getReduceStatus()==1){
							tSyncexSky.setStatus(0);
							str= content;
						}else{
							tSyncexSky.setStatus(601);
							str ="status=601";
						}
					}					
				}					
					syncexSkyMapper.updateByPrimaryKeySelective(tSyncexSky);
					
						
					
				}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			str="601";
		}
		
		return str;
	}



}
