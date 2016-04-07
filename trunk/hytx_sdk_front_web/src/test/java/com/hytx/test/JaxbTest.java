package com.hytx.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.hytx.util.JaxbUtil;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxbTest {
	@XmlElement(name = "return_code")
	private String returnCode;
	@XmlElement(name = "return_msg")
	private String returnMsg;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public static void main(String[] args) {
		String str = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[您没有APP支付权限]]></return_msg></xml>";
		JaxbTest obj = JaxbUtil.converyToJavaBean(str, JaxbTest.class);
		System.out.println(obj.getReturnMsg());

	}

}
