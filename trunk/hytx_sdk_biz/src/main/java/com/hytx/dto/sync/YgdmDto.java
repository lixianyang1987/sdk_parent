package com.hytx.dto.sync;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class YgdmDto {
	
	private String ctype;
	private String channel_id;
	private String sid;
	private String item_id;
	private String imsi;
	private String imei;
	private String price;
	private String status;
	private String phone_number;
	private String message;
	private String trans_id;
	private String result;
	private String player_url;
	private String cpparam;
	
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPlayer_url() {
		return player_url;
	}
	public void setPlayer_url(String player_url) {
		this.player_url = player_url;
	}
	public String getCpparam() {
		return cpparam;
	}
	public void setCpparam(String cpparam) {
		this.cpparam = cpparam;
	}
	public String getExcode() {
		return excode;
	}
	public void setExcode(String excode) {
		this.excode = excode;
	}
	private String excode;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YgdmDto [ctype=");
		builder.append(ctype);
		builder.append(", channel_id=");
		builder.append(channel_id);
		builder.append(", sid=");
		builder.append(sid);
		builder.append(", item_id=");
		builder.append(item_id);
		builder.append(", imsi=");
		builder.append(imsi);
		builder.append(", imei=");
		builder.append(imei);
		builder.append(", price=");
		builder.append(price);
		builder.append(", status=");
		builder.append(status);
		builder.append(", phone_number=");
		builder.append(phone_number);
		builder.append(", message=");
		builder.append(message);
		builder.append(", trans_id=");
		builder.append(trans_id);
		builder.append(", result=");
		builder.append(result);
		builder.append(", player_url=");
		builder.append(player_url);
		builder.append(", cpparam=");
		builder.append(cpparam);
		builder.append(", excode=");
		builder.append(excode);
		builder.append("]");
		return builder.toString();
	}

}
