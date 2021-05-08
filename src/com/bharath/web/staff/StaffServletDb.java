package com.bharath.web.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StaffServletDb {
	private DataSource dataSource;

	public StaffServletDb(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public List<Student> getStudentDetails(String sub) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Student> stu = new ArrayList<Student>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		try {
			con = dataSource.getConnection();

			String sql = "select * from student where st_subject=?";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, sub);
			
			res = stmt.executeQuery();
	

			while (res.next()) {
				Student obj = new Student();
				obj.setStudentId(res.getInt("id"));
				obj.setStudentFName(res.getString("fname"));
				obj.setStudentLName(res.getString("lname"));
				obj.setStudentSubject(res.getString("st_subject"));
				obj.setStudentEmail(res.getString("st_auth_email"));
				obj.setStudentMarks(res.getInt("sub_marks"));
				stu.add(obj);
				
			}

			return stu;
		} finally {
			close(con, stmt, res);
		}
	}

	public Student getStudent(int id) throws SQLException {
		// TODO Auto-generated method stub
		List<Student> stu = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from student where id=?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			res = stmt.executeQuery();
			Student obj = new Student();
			if (res.next()) {

				
				obj.setStudentId(res.getInt("id"));
				obj.setStudentFName(res.getString("fname"));
				obj.setStudentLName(res.getString("lname"));
				obj.setStudentSubject(res.getString("st_subject"));
				obj.setStudentEmail(res.getString("st_auth_email"));
				obj.setStudentMarks(res.getInt("sub_marks"));
				stu.add(obj);

			}
			return obj;
		} finally {
			close(con, stmt, res);
		}
	}

	public void UpdateMarks(int id, int marks) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt= null;
		try {
			con=dataSource.getConnection();
			
			String sql="update student set sub_marks=? where id=?";
			
			stmt=con.prepareStatement(sql);
			
			
			stmt.setInt(1, marks);
			stmt.setInt(2, id);
			
			stmt.execute();
			
			
		} finally {
			close(con,stmt,null);
		}
	}

	public List<Staff> getStaffDetails(String sub) throws SQLException {
		// TODO Auto-generated method stub
		List<Staff> stu = new ArrayList<Staff>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		try {
			con = dataSource.getConnection();

			String sql = "select * from staff where sf_subject=?";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, sub);
			
			res = stmt.executeQuery();
	

			while (res.next()) {
				Staff obj = new Staff();
				obj.setStaffId(res.getInt("id"));
				obj.setStaffFName(res.getString("fname"));
				obj.setStaffLName(res.getString("lname"));
				obj.setStaffSubject(res.getString("sf_subject"));
				obj.setStaffEmail(res.getString("sf_auth_email"));
				stu.add(obj);
				
			}

			return stu;
		} finally {
			close(con, stmt, res);
		}
	}

	public List<Student> getStudentDetails1(String sub) throws SQLException {
		List<Student> stu = new ArrayList<Student>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		try {
			con = dataSource.getConnection();

			String sql = "select * from student where st_subject=?";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, sub);
			
			res = stmt.executeQuery();
	

			while (res.next()) {
				Student obj = new Student();
				obj.setStudentId(res.getInt("id"));
				obj.setStudentFName(res.getString("fname"));
				obj.setStudentLName(res.getString("lname"));
				obj.setStudentSubject(res.getString("st_subject"));
				obj.setStudentEmail(res.getString("st_auth_email"));
				obj.setStudentMarks(res.getInt("sub_marks"));
				stu.add(obj);
				
			}

			return stu;
		} finally {
			close(con, stmt, res);
		}
		
	}
}
