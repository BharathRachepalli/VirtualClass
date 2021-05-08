package com.bharath.web.assig;


import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class AssigServletDb {
	private DataSource dataSource;

	public AssigServletDb(DataSource dataSource) {
		
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

	public void uploadAssig(String id, String email, File thefile) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt= null;
		
		FileReader input = null;
		try {
			con=dataSource.getConnection();
			
			String sql="update student set assignment=? where st_auth_email=? and st_subject=?";
			
			stmt=con.prepareStatement(sql);
			
			File file=thefile;
			input = new FileReader(file);
			
			stmt.setCharacterStream(1, input);
			stmt.setString(2, email);
			stmt.setString(3, id);
			
			stmt.executeUpdate();
			
			
		} finally {
			close(con,stmt,null);
		}
	}

	public void downloadAssig(String id, String email) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		Reader input = null;
		FileWriter output = null;
		
		try {
			con=dataSource.getConnection();
			
			String sql = "select assignment from student where st_auth_email=? and st_subject=?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, id);
			
			res=stmt.executeQuery();
			
			File file1=new File("C:\\Users\\DARK PRINCE\\Desktop\\test\\SeemaOnlineAssignment\\AssignementDownload\\"+email+".txt");
			file1.createNewFile();
			output = new FileWriter(file1);
			
			
			if (res.next()) {

				input = res.getCharacterStream("assignment"); 
				
				int theChar;
				while ((theChar = input.read()) > 0) {
					output.write(theChar);
					
				}
			
			}
			output.close();
		}finally {
			close(con,stmt,res);
		}
	}
	
	
}
