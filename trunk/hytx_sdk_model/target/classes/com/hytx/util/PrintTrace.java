package com.hytx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintTrace {
	private static Logger logger = LoggerFactory.getLogger(PrintTrace.class);

	public static void princeThreadTrace() {
		if (logger.isDebugEnabled()) {
			StackTraceElement[] trace = Thread.currentThread().getStackTrace();
			System.out
					.println("*******************************************************************************");
			for (int i = trace.length - 1; i >= 0; i--) {
				System.out.println(trace[i].toString());
			}
			System.out
					.println("*******************************************************************************");
		}
		
	}

}
