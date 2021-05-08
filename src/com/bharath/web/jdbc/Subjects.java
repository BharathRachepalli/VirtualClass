package com.bharath.web.jdbc;

public class Subjects {

	private int sId;
	private String sName;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "Subjects [sId=" + sId + ", sName=" + sName + "]";
	}
	
	
}
