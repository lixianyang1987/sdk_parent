package com.hytx.dto.baseConf;

import java.io.Serializable;
import com.hytx.model.baseConf.ChannelApp;

public class ChannelAppDto extends ChannelApp  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String channelName;
	private String appName;
	
	private Integer smId;
	
	private String smName;

	public Integer getSmId() {
		return smId;
	}

	public void setSmId(Integer smId) {
		this.smId = smId;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
