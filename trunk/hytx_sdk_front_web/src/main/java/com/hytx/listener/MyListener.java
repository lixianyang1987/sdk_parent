package com.hytx.listener;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;

import com.hytx.model.syncEx.SyncByLog;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.SyncByLogServiceImpl;
import com.hytx.util.HttpClientUtil;
import com.hytx.web.syncEx.SyncTyAllController;

public class MyListener implements ServletContextListener {

	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("启动定时器");
		SyncTyAllController sc =new SyncTyAllController();
		Thread t=	new Thread(){
			public void run() {
				while(true){
					try {	
						Thread.sleep(1000*60);
						
						String s=HttpClientUtil.simpleVisitUrl("http://127.0.0.1:8080/sdk_web/sync/synclogs");
						if(s.equals("ok")){
							break;
						}else{
							s=HttpClientUtil.simpleVisitUrl("http://114.55.72.136/sync/synclogs");
							if(s.equals("ok")){
								break;
								
							}else{
								continue;
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						try {
							String 	s=HttpClientUtil.simpleVisitUrl("http://114.55.72.136/sync/synclogs");
							if(s.equals("ok")){
								break;								
							}
						} catch (HttpException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
				}
				
		};
		t.start();
	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

}
