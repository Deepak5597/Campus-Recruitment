package com.birla.cr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.birla.cr.dao.Dao;

/**
 * Servlet implementation class LoginImpl
 */
@WebServlet("/LoginImpl")
public class LoginImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginImpl() {
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String role = request.getParameter("role");
		Dao d=new Dao();
		String login_status = d.verifyPassword(email, password, role);
		if(login_status.equals("success")) {
			HttpSession  session = request.getSession(false);
			session.setAttribute("u_name", email);
			session.setAttribute("role", role);
			if(role.equals("student")) {
				response.sendRedirect("studentdashboard.jsp");
			}
			else if(role.equals("admin")){
				response.sendRedirect("admindashboard.jsp");					
			}else {
				response.sendRedirect("coordinatordashboard.jsp");					
			}
		}else {
			if(login_status.equals("notexist")) {
				if(role.equals("student")) {
					response.sendRedirect("login.jsp?role=student&err=notexist");
				}
				else if(role.equals("admin")){
					response.sendRedirect("login.jsp?role=admin&err=notexist");					
				}else {
					response.sendRedirect("login.jsp?role=coordinator&err=notexist");					
				}
			}else {
				if(role.equals("student")) {
					response.sendRedirect("login.jsp?role=student&err=fail");
				}
				else if(role.equals("admin")){
					response.sendRedirect("login.jsp?role=admin&err=fail");					
				}else {
					response.sendRedirect("login.jsp?role=coordinator&err=fail");					
				}
			}
		}
	}

}
