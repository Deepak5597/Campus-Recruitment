package com.birla.cr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.birla.cr.model.SqlQuery;

public class Dao {
	
	private static String URL="jdbc:oracle:thin:@sc02client02.daytonoh.ncr.com:1554:DEV30A";
	private static String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static String USER="apps";
	private static String PASSWORD="adev30apws";
	static Connection con=null;

	static {
		try {
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL,USER,PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String verifyEmail(String email) {
		try {
		PreparedStatement verify_ps=con.prepareStatement(SqlQuery.verifyEmail);
		verify_ps.setString(1, email);
		ResultSet rs = verify_ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		if(count > 0) {
			return "success";
		}else {
			return "fail";
		}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String studentSignup(String[] signupArr,String[] profileArr) {
		try {
		PreparedStatement signup_ps=con.prepareStatement(SqlQuery.signupQuery);
		PreparedStatement profile_ps=con.prepareStatement(SqlQuery.addStudentProfile);
		signup_ps.setString(1, signupArr[0]);
		signup_ps.setString(2, signupArr[1]);
		signup_ps.setString(3, signupArr[2]);
		
		profile_ps.setString(1, profileArr[0]);
		profile_ps.setString(2, profileArr[1]);
		profile_ps.setString(3, profileArr[2]);
		profile_ps.setString(4, profileArr[3]);
		profile_ps.setString(5, profileArr[4]);
		profile_ps.setString(6, profileArr[5]);
		profile_ps.setString(7, profileArr[6]);
		profile_ps.setString(8, profileArr[7]);
		profile_ps.setString(9, profileArr[8]);
		profile_ps.setString(10, profileArr[9]);
		profile_ps.setString(11, profileArr[10]);
		profile_ps.setString(12, profileArr[11]);
		profile_ps.setString(13, profileArr[12]);
		profile_ps.setString(14, profileArr[13]);
		profile_ps.setString(15, profileArr[14]);
		profile_ps.setString(16, profileArr[15]);
		profile_ps.setString(17, profileArr[16]);
		profile_ps.setString(18, profileArr[17]);
		
		int i = signup_ps.executeUpdate();
		if(i > 0) {
			int j = profile_ps.executeUpdate();
			if(j >0 ) {
				return "success";
			}else {
				return "fail";
			}
		}else {
			return "fail";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String coordinatorSignup(String signupArr[],String profileArr[]) {
		try {
		PreparedStatement signup_ps=con.prepareStatement(SqlQuery.signupQuery);
		PreparedStatement profile_ps=con.prepareStatement(SqlQuery.addCoordinatorProfile);
		
		signup_ps.setString(1, signupArr[0]);
		signup_ps.setString(2, signupArr[1]);
		signup_ps.setString(3, signupArr[2]);
		
		profile_ps.setString(1, profileArr[0]);
		profile_ps.setString(2, profileArr[1]);
		profile_ps.setString(3, profileArr[2]);
		profile_ps.setString(4, profileArr[3]);
		profile_ps.setString(5, profileArr[4]);
		profile_ps.setString(6, profileArr[5]);
		profile_ps.setString(7, profileArr[6]);
		profile_ps.setString(8, profileArr[7]);
		profile_ps.setString(9, profileArr[8]);
		profile_ps.setString(10, profileArr[9]);
		profile_ps.setString(11, profileArr[10]);
		profile_ps.setString(12, profileArr[11]);
		profile_ps.setString(13, profileArr[12]);
		int i = signup_ps.executeUpdate();
		if(i > 0) {
			int j = profile_ps.executeUpdate();
			if(j >0 ) {
				return "success";
			}else {
				return "fail";
			}
		}else {
			return "fail";
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String verifyPassword(String email , String password , String role) {
		try {	
		PreparedStatement verify_ps=con.prepareStatement(SqlQuery.verifyPassword);
		verify_ps.setString(1, email);
		verify_ps.setString(2, role);
		ResultSet rs = verify_ps.executeQuery();
		String table_password = null;
		while(rs.next()) {
			 table_password = rs.getString(1);
		}
		if(table_password == null) {
			return "notexist";
		}else {
			if(table_password.equals(password)) {
				return "success";
			}else {
				return "fail";
			}
		}	

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
