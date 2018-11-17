package com.birla.cr.model;

public class SqlQuery {
	
	public static String verifyEmail="select count(u_name) from cr_users where u_name=?";
	public static String signupQuery="insert into cr_users values(?,?,?)";
	public static String addStudentProfile="insert into cr_candidate_profile values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String addCoordinatorProfile="insert into cr_coordinator_profile values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String verifyPassword="select u_password from cr_users where u_name=? and u_role=?";
}
