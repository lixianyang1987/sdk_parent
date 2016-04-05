package com.hytx.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.hytx.util.JsonMapper;

public class JsonRespXinPaySms {
	private String resultCode;// 状态码
	private String persentCode;// 是否弹窗二次确认
	

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}


	public String getPersentCode() {
		return persentCode;
	}

	public void setPersentCode(String persentCode) {
		this.persentCode = persentCode;
	}

	@Override
	public String toString() {
		return JsonMapper.toLogJson(this).toString();
	}
}
