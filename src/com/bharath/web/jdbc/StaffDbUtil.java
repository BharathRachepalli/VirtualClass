package com.bharath.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StaffDbUtil {
	private DataSource dataSource;

	public StaffDbUtil(DataSource dataSource) {
		
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
	public void AddStaff(Staff stu) {
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
			stmt1.setString(1, stu.getStaffSubject());
			res = stmt1.executeQuery();
			int ID = 0;
			if (res.next()) {
				ID = (int) res.getInt("id");
			}
//			System.out.println(ID);
//			System.out.println(stu);
			String sql = "INSERT INTO `staff` (`fname`,`lname`,`sf_subject`,`sf_auth_email`) VALUES (?,?,?,?)";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, stu.getStaffFName());
			stmt.setString(2, stu.getStaffLName());
			stmt.setInt(3, ID);
			stmt.setString(4, stu.getStaffEmail());

			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, stmt, res);
		}
	}
	public List<Staff> GetStaffList() throws SQLException {
		// TODO Auto-generated method stub
		List<Staff> stu = new ArrayList<Staff>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			con = dataSource.getConnection();

			String sql = "select * from staff";

			stmt = con.createStatement();

			res = stmt.executeQuery(sql);

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
	public Staff getStaff(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from staff where id=?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			res = stmt.executeQuery();

			Staff stu = new Staff();
			if (res.next()) {

				stu.setStaffId(res.getInt("id"));
				stu.setStaffFName(res.getString("fname"));
				stu.setStaffLName(res.getString("lname"));
				stu.setStaffSubject(res.getString("sf_subject"));
				stu.setStaffEmail(res.getString("sf_auth_email"));

			}
			return stu;
		} finally {
			close(con, stmt, res);
		}
		
	}
	public void updateStaff(int id, String fname, String lname) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt= null;
		try {
			con=dataSource.getConnection();
			
			String sql="update staff set fname=?,lname=? where id=?";
			
			stmt=con.prepareStatement(sql);
			
			
			stmt.setString(1, (String)fname);
			stmt.setString(2, (String)lname);
			stmt.setInt(3, id);
			
			stmt.execute();
			
			
		} finally {
			close(con,stmt,null);
		}
	}
	public void deleteStaff(int id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt= null;
		try {
			con=dataSource.getConnection();
			
			String sql="delete from staff where id=?";
			
			stmt=con.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			stmt.execute();
			
			
		} finally {
			close(con,stmt,null);
		}
		
	}

}
