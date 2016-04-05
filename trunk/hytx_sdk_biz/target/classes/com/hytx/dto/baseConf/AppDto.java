package com.hytx.dto.baseConf;

import java.io.Serializable;
import com.hytx.model.baseConf.App;

public class AppDto extends App  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpName;
	
	private String smName;
	
	
	

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

}
