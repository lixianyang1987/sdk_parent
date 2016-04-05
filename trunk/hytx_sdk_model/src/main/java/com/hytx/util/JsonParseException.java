package com.hytx.util;

public class JsonParseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Throwable throwable;

	public JsonParseException(Throwable t) {
		this.throwable = t;
	}

	public static RuntimeException wrap(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException) t;
		return new JsonParseException(t);
	}

	public Throwable getCause() {
		return this.throwable;
	}

	public void printStackTrace() {
		this.throwable.printStackTrace();
	}
}
