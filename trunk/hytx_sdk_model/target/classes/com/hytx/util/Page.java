package com.hytx.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	/* 当前页标 */
	private int pageIndex = 1;
	/* 当前页数据开始索引 */
	private int pageStartIndex;
	/* 分页大小 */
	private int pageSize = 50;
	/* 总分页数 */
	private int pageCount;
	/* 总数据量 */
	private int totalCount;
	/* 当前页数据查询url */
	private String url;
	/* 扩展属性 */
	private Map<String, Object> exMap = new HashMap<String, Object>();

	public Page() {
		setPageIndex(1);
	};

	/**
	 * 当前页上的结果列表
	 */
	private List<T> resultList;

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if (pageIndex > 0) {
			this.pageIndex = pageIndex;
		}
		if (this.pageIndex > 1) {
			setPageStartIndex((pageIndex - 1) * pageSize + 1);
		} else {
			setPageStartIndex(1);
		}
	}

	public void setPageIndex(String pageIndex) {
		if (pageIndex != null) {
			try {
				setPageIndex(Integer.parseInt(pageIndex));
			} catch (Exception e) {
			}
		}
	}

	public int getPageStartIndex() {
		return pageStartIndex;
	}

	public int getPageEndIndex() {
		return pageStartIndex + pageSize - 1;
	}

	public void setPageStartIndex(int pageStartIndex) {
		this.pageStartIndex = pageStartIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setPageIndex(this.pageIndex);
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		if (this.totalCount > 0 && this.pageCount > 0 && pageIndex > pageCount) {
			setPageIndex(pageCount);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public Map<String, Object> getExMap() {
		return exMap;
	}

	public void setExMap(Map<String, Object> exMap) {
		this.exMap = exMap;
	}

}
