package com.bharath.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SubjectDbUtil {
	private DataSource dataSource;

	public SubjectDbUtil(DataSource dataSource) {
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

	public void SubjectDbUtil(String sub) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO `subjects` (`sname`) VALUES (?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sub);
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, stmt, null);
		}
	}

	public List<Subjects> getSubjects() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Subjects> sub = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		
		
		
		try {
			con = dataSource.getConnection();
			
			String sql = "select * from subjects";
			
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);
			
			while (res.next()) {
				Subjects obj = new Subjects();
				obj.setsId(res.getInt("id"));
				obj.setsName(res.getString("sname"));
				sub.add(obj);
			}
			return sub;
		}finally {
			close(con,stmt,res);
		}
		
		
	}
}
