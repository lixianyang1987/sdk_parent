package com.hytx.dto.sms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.FileUtils;

import com.hytx.util.JaxbUtil;

@XmlRootElement(name = "response")
public class SmsResponseDto {
	private String code;

	private List<Message> messageList = new ArrayList<Message>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement(name = "message")
	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	@XmlRootElement(name = "message")
	private static class Message {
		private String desmobile;
		private String msgid;

		public String getDesmobile() {
			return desmobile;
		}

		public void setDesmobile(String desmobile) {
			this.desmobile = desmobile;
		}

		public String getMsgid() {
			return msgid;
		}

		public void setMsgid(String msgid) {
			this.msgid = msgid;
		}

	}

	public static void main(String[] args) {
		/*	SmsResponseDto dto = new SmsResponseDto();
			dto.setCode("123");
			Message m1 = new SmsResponseDto.Message();
			m1.setDesmobile("13581959582");
			m1.setMsgid("mssss");
			dto.getMessageList().add(m1);
			dto.getMessageList().add(m1);
			dto.getMessageList().add(m1);
			String content = JaxbUtil.convertToXml(dto);
			System.out.println(content);*/

		try {
			String fileContent = FileUtils.readFileToString(new File(
					"F://ceshi.txt"));
			SmsResponseDto dto = JaxbUtil.converyToJavaBean(fileContent,
					SmsResponseDto.class);
			System.out.println(dto.getMessageList().size());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
