package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.MemberDAO;

//6. isEmailExist 함수는 전달받은 email이 member 테이블 내에 존재하는지 검사하고 그 결과를 boolean 으로 반환한다.
@WebServlet("/ChcekEmail")
@ResponseBody
@RequestMapping("/CheckEmail")
public class ChcekEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChcekEmail() {
    	MemberDAO dao = new MemberDAO();
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter resp= response.getWriter;
    	String email = request.getParameter(email);
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
