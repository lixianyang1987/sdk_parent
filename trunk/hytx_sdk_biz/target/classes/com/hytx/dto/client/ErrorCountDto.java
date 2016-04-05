package com.hytx.dto.client;

import java.io.Serializable;

/****
 * 错误计数器
 * 
 * @author houzz
 *
 */
public class ErrorCountDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int count;
	private long lockTimesSecond;
	private long createTimes;
	private long expireTimes;

	public ErrorCountDto(long lockTimesSecond) {
		this.createTimes = System.currentTimeMillis();
		this.lockTimesSecond = lockTimesSecond;
		this.expireTimes = this.createTimes + lockTimesSecond * 1000;
		this.count = 1;
	}

	public void reset() {
		this.createTimes = System.currentTimeMillis();
		this.expireTimes = this.createTimes + this.lockTimesSecond * 1000;
		this.count = 0;
	}

	public boolean expired() {
		return System.currentTimeMillis() > expireTimes;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getCreateTimes() {
		return createTimes;
	}

	public void setCreateTimes(long createTimes) {
		this.createTimes = createTimes;
	}

	public long getExpireTimes() {
		return expireTimes;
	}

	public void setExpireTimes(long expireTimes) {
		this.expireTimes = expireTimes;
	}

	public long getLockTimesSecond() {
		return lockTimesSecond;
	}

	public void setLockTimesSecond(long lockTimesSecond) {
		this.lockTimesSecond = lockTimesSecond;
	}

	public long getLeftSeconds() {
		long leftMillis = this.expireTimes - System.currentTimeMillis();
		if (leftMillis > 0) {
			return leftMillis / 1000;
		}
		return 0;
	}

}
