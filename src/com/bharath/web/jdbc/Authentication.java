package com.bharath.web.jdbc;

public class Authentication {
	
	
	private String email;
	private String pwd;
	private String logintype;
	
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
	@Override
	public String toString() {
		return "Authentication [email=" + email + ", pwd=" + pwd + ", logintype=" + logintype + "]";
	}
	
	
}
