package com.kh.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDAO;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		try {
			boolean result = dao.login(id, pwd);
			if(result) {
				pw.println("사용 가능한 이메일 입니다!");
			} else {
				pw.println("이미 사용중인 이메일 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("조회하는 도중 오류가 발생했습니다.");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
}