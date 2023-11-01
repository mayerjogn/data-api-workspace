package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "kh";
		String pw = "kh";
		
		return DriverManager.getConnection(url, id, pw);
		
	}
	public boolean login(String id, String pwd) throws Exception{
		String sql= "select id from members where id=? and pwd=?";
		
		Connection conn = this.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		
		// 6. isEmailExist 함수는 전달받은 email이 member 테이블 내에 존재하는지 검사하고 그 결과를 boolean 으로 반환한다.
		return rs.next();
	}
}
