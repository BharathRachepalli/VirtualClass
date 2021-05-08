package com.bharath.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {

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

	public void AddStudent(Students stu) {
		// TODO Auto-generated method stub
		Connection con = null;
		Connection con1 = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet res = null;

		try {
			con1 = dataSource.getConnection();
			con = dataSource.getConnection();
			stmt1 = con1.prepareStatement("select id from subjects where sname = ?");
			stmt1.setString(1, stu.getStudentSubject());
			res = stmt1.executeQuery();
			int ID = 0;
			if (res.next()) {
				ID = (int) res.getInt("id");
			}
//			System.out.println(ID);
//			System.out.println(stu);
			String sql = "INSERT INTO `student` (`fname`,`lname`,`st_subject`,`st_auth_email`) VALUES (?,?,?,?)";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, stu.getStudentFName());
			stmt.setString(2, stu.getStudentLName());
			stmt.setInt(3, ID);
			stmt.setString(4, stu.getStudentEmail());

			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, stmt, res);
		}

	}

	public List<Students> GetStudentList() throws SQLException {
		// TODO Auto-generated method stub
		List<Students> stu = new ArrayList<Students>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			con = dataSource.getConnection();

			String sql = "select * from student";

			stmt = con.createStatement();

			res = stmt.executeQuery(sql);

			while (res.next()) {
				Students obj = new Students();
				obj.setStudentId(res.getInt("id"));
				obj.setStudentFName(res.getString("fname"));
				obj.setStudentLName(res.getString("lname"));
				obj.setStudentSubject(res.getString("st_subject"));
				obj.setStudentEmail(res.getString("st_auth_email"));
				stu.add(obj);
			}

			return stu;
		} finally {
			close(con, stmt, res);
		}

	}

	public Students getStu(int id) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from student where id=?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			res = stmt.executeQuery();

			Students stu = new Students();
			if (res.next()) {

				stu.setStudentId(res.getInt("id"));
				stu.setStudentFName(res.getString("fname"));
				stu.setStudentLName(res.getString("lname"));
				stu.setStudentSubject(res.getString("st_subject"));
				stu.setStudentEmail(res.getString("st_auth_email"));

			}
			return stu;
		} finally {
			close(con, stmt, res);
		}

	}

	public void updateStudent(int id, String fname, String lname) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt= null;
		try {
			con=dataSource.getConnection();
			
			String sql="update student set fname=?,lname=? where id=?";
			
			stmt=con.prepareStatement(sql);
			
			
			stmt.setString(1, (String)fname);
			stmt.setString(2, (String)lname);
			stmt.setInt(3, id);
			
			stmt.execute();
			
			
		} finally {
			close(con,stmt,null);
		}
	}

	public void deleteStudent(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt= null;
		try {
			con=dataSource.getConnection();
			
			String sql="delete from student where id=?";
			
			stmt=con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			stmt.execute();
			
			
		} finally {
			close(con,stmt,null);
		}
	}

}
