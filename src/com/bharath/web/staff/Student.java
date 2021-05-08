package com.bharath.web.staff;

public class Student {
	private int studentId;
	private String studentFName;
	private String studentLName;
	private String studentSubject;
	private String studentEmail;
	private int studentMarks;
	
	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentFName() {
		return studentFName;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public String getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFName=" + studentFName + ", studentLName=" + studentLName
				+ ", studentSubject=" + studentSubject + ", studentEmail=" + studentEmail + ", StudentMarks="
				+ studentMarks + "]";
	}

	
}
