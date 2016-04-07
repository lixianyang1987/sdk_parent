package com.hytx.dto.sync;



public class ZxjmRdoDto {
private String	mcpid ;
private String 	orderNo ;
private String	feeCode ;
private String	reqTime ;
private String	sign ;
private String	layout ;
private String	cm ;
private String	payTime ;
private String	resultCode ;
 
 
 
 
 
 

public String getPayTime() {
	return payTime;
}
public void setPayTime(String payTime) {
	this.payTime = payTime;
}
public String getResultCode() {
	return resultCode;
}
public void setResultCode(String resultCode) {
	this.resultCode = resultCode;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ZxjmRdoDto [mcpid=");
	builder.append(mcpid);
	builder.append(", orderNo=");
	builder.append(orderNo);
	builder.append(", feeCode=");
	builder.append(feeCode);
	builder.append(", reqTime=");
	builder.append(reqTime);
	builder.append(", sign=");
	builder.append(sign);
	builder.append(", layout=");
	builder.append(layout);
	builder.append(", cm=");
	builder.append(cm);
	builder.append("]");
	return builder.toString();
}
public String getMcpid() {
	return mcpid;
}
public void setMcpid(String mcpid) {
	this.mcpid = mcpid;
}
public String getOrderNo() {
	return orderNo;
}
public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
}
public String getFeeCode() {
	return feeCode;
}
public void setFeeCode(String feeCode) {
	this.feeCode = feeCode;
}
public String getReqTime() {
	return reqTime;
}
public void setReqTime(String reqTime) {
	this.reqTime = reqTime;
}
public String getSign() {
	return sign;
}
public void setSign(String sign) {
	this.sign = sign;
}
public String getLayout() {
	return layout;
}
public void setLayout(String layout) {
	this.layout = layout;
}
public String getCm() {
	return cm;
}
public void setCm(String cm) {
	this.cm = cm;
}


}
