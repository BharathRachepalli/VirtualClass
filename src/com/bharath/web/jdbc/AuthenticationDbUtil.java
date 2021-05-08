package com.bharath.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class AuthenticationDbUtil {
	
	private DataSource dataSource;

	public AuthenticationDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Authentication> getAuthentication() throws SQLException{
		
		List<Authentication> authentications = new ArrayList<Authentication>();
		
		Connection con = null;
		Statement stmt= null;
		ResultSet res = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "select * from authentication";
			
			stmt = con.createStatement();
			
			res = stmt.executeQuery(sql);
			
			while (res.next()) {
				Authentication obj = new Authentication();
				obj.setEmail(res.getString("email"));
				obj.setPwd(res.getString("pwd"));
				obj.setLogintype(res.getString("logintype"));
				authentications.add(obj);
			}
			
			return authentications;
		} 
		finally {
			close(con,stmt,res);
		}
		
		
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
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addAuthentication(Authentication aut) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement stmt= null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "INSERT INTO `authentication` (`email`,`pwd`,`logintype`) VALUES (?,?,?)";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aut.getEmail());
			stmt.setString(2, aut.getPwd());
			stmt.setString(3, aut.getLogintype());
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con,stmt,null);
		}
		
		
		
		
	}

	public Authentication getAuth(String email) throws SQLException {
//		Authentication auth=null;
		
		Connection con = null;
		PreparedStatement stmt= null;
		ResultSet res = null;
		String aEmail;
		
		try {
			
			aEmail = (String) email;
			con= dataSource.getConnection();
			
			String sql="select * from authentication where email=?";
			
			stmt=con.prepareStatement(sql);
			
			stmt.setString(1, aEmail);
			
			res=stmt.executeQuery();
			Authentication Oauth = new Authentication();
			if(res.next()) {
				
				Oauth.setEmail(res.getString("email"));
				Oauth.setPwd(res.getString("pwd"));
				Oauth.setLogintype(res.getString("logintype"));
			}
			return Oauth;
		}finally {
			close(con,stmt,res);
		}
		
	}

	public void updateAuth(String aEmail, String password, String logintype) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt= null;
		
		
		try {
			con=dataSource.getConnection();
			
			String sql="update authentication set pwd=?,logintype=? where email=?";
			
			stmt=con.prepareStatement(sql);
			
			stmt.setString(1, (String)password);
			stmt.setString(2, (String)logintype);
			stmt.setString(3, (String)aEmail);
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(con,stmt,null); 
		}
	}

	
	
}
