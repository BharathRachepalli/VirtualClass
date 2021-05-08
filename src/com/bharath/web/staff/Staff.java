package com.bharath.web.staff;

public class Staff {
	
	private int staffId;
	private String staffFName;
	private String staffLName;
	private String staffSubject;
	private String staffEmail;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffFName() {
		return staffFName;
	}
	public void setStaffFName(String staffFName) {
		this.staffFName = staffFName;
	}
	public String getStaffLName() {
		return staffLName;
	}
	public void setStaffLName(String staffLName) {
		this.staffLName = staffLName;
	}
	public String getStaffSubject() {
		return staffSubject;
	}
	public void setStaffSubject(String staffSubject) {
		this.staffSubject = staffSubject;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffFName=" + staffFName + ", staffLName=" + staffLName
				+ ", staffSubject=" + staffSubject + ", staffEmail=" + staffEmail + "]";
	}
	
	
}
