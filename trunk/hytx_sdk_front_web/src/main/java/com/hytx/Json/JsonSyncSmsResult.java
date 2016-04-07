package com.hytx.Json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.validator.constraints.NotEmpty;

import com.hytx.util.CustomDateDeserializer;
import com.hytx.util.MD5;

public class JsonSyncSmsResult extends JsonSdkReqBase {
	@NotEmpty
	private List<Long> commandIdList = new ArrayList<Long>();
	@NotEmpty
	private List<Integer> statusList = new ArrayList<Integer>();
	@NotNull
	private Date orderDt;// 订购日期

	public List<Long> getCommandIdList() {
		return commandIdList;
	}

	public void setCommandIdList(List<Long> commandIdList) {
		this.commandIdList = commandIdList;
	}

	public List<Integer> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	public Date getOrderDt() {
		return orderDt;
	}

	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	@Override
	public String getColculateSign(String encryKey) {
		StringBuilder builder = new StringBuilder();
		builder.append(this.sdkVersion);
		builder.append("|");
		builder.append(this.channelAppKey);
		builder.append("|");
		builder.append(this.imsi);
		builder.append("|");
		builder.append(this.extraInfo);
		builder.append("|");
		builder.append(this.iccid);
		builder.append("|");
		builder.append(DateFormatUtils.format(this.orderDt,
				"yyyy-MM-dd HH:mm:ss"));
		builder.append("|");
		builder.append(this.commandIdList);
		builder.append("|");
		builder.append(this.statusList);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

	public static void main(String[] args) {
		System.out.println(DateFormatUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
	}

}
