package com.hytx.dto.count;

/***
 * 省份限量查询Dto
 * 
 * @author houzz
 *
 */
public class DayLimitDto {
	private Integer id;
	private String name;
	private String provinceName;
	private Integer dayLimit;
	private Integer consumer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDayLimit() {
		return dayLimit;
	}

	public void setDayLimit(Integer dayLimit) {
		this.dayLimit = dayLimit;
	}

	public Integer getConsumer() {
		return consumer;
	}

	public void setConsumer(Integer consumer) {
		this.consumer = consumer;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}
