package com.hytx.web.base;

public class NoAuthException extends IllegalAccessException{
	public NoAuthException(String msg){
		super(msg);
	}

}
