package com.hytx.dto.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuNodeDto  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer pid;
	private String state;
	private String text;
	private String iconCls;
	private String checked;
	private Map<String, Object> attributes=new HashMap<String,Object>();
	private List<MenuNodeDto> children = new ArrayList<MenuNodeDto>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<MenuNodeDto> getChildren() {
		return children;
	}

	public void setChildren(List<MenuNodeDto> children) {
		this.children = children;
	}

}
