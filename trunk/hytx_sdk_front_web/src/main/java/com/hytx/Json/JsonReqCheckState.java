package com.hytx.Json;

import com.hytx.util.JsonMapper;
import com.hytx.util.MD5;

public class JsonReqCheckState extends JsonSdkReqBase {

	@Override
	public String getColculateSign(String encryKey) {
		StringBuilder builder = new StringBuilder();
		builder.append(this.sdkVersion);
		builder.append("|");
		builder.append(this.channelAppKey);
		builder.append("|");
		builder.append(this.imsi);
		builder.append("|");
		builder.append(this.iccid);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

	@Override
	public String toString() {
		return JsonMapper.toLogJson(this).toString();
	}
}
