package com.birla.cr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.birla.cr.dao.Dao;

/**
 * Servlet implementation class CoordinatorSignupImpl
 */
@WebServlet("/CoordinatorSignupImpl")
public class CoordinatorSignupImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoordinatorSignupImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String email = request.getParameter("email");    
		String password = request.getParameter("password");
		String role="coordinator";
		String f_name = request.getParameter("f_name");
		String m_name = request.getParameter("m_name");
		String l_name = request.getParameter("l_name");
		String father_name = request.getParameter("father_name");
		String mother_name = request.getParameter("mother_name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String college="Birla institute of applied sciences Bhimtal, Nanital";
		String course = request.getParameter("course");
		String branch = request.getParameter("branch");
		
		Dao d = new Dao();
		String verifyEmail = d.verifyEmail(email);
		if(verifyEmail.equals("fail")) {
			
		String signUpArr[] = new String[3];
		String profileArr[] = new String[18];
		
		signUpArr[0]=email;signUpArr[1]=password;signUpArr[2]=role;
				
		profileArr[0]=email;profileArr[1]=f_name;profileArr[2]=m_name;profileArr[3]=l_name;
		profileArr[4]=father_name;profileArr[5]=mother_name;profileArr[6]=dob;profileArr[7]=gender;
		profileArr[8]=mobile;profileArr[9]=address;profileArr[10]=college;profileArr[11]=course;
		profileArr[12]=branch;
		
		String sigup_status = d.coordinatorSignup(signUpArr, profileArr);
		if(sigup_status.equals("success")) {
			response.sendRedirect("loginwindow.jsp");			
		}else {
			response.sendRedirect("signupcoordinator.jsp?err=serverError");
		}
		
		}else {
			response.sendRedirect("signupcoordinator.jsp?err=duplicateemail");
		}
		
		
	}

}
