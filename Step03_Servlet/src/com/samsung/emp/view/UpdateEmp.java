package com.samsung.emp.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement stmt = null;
		

		try {
			// 1단계 => 사용할 클래스를 올리자
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계 => 디비 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3단계 => Query 준비
			// PreparedStatement 객체는 쿼리 실행전에 해야 할 일에 대한 메소드를 가지고 있다
			String sql = "update emp set salary = ?, commission = ?, did = ? where id = ?";
			stmt = conn.prepareStatement(sql);
			
			// 4단계 => 쿼리에 들어갈 변수들을 세팅 작업
			// ?에 대한 세팅 작업
			stmt.setInt(1, 5000);
			stmt.setDouble(2, 0.05);
			stmt.setInt(3, 100);
			stmt.setInt(4, 208);
			
			// 5단계 => 쿼리를 실행하고 그 결과값을 받아온다
			// select => stmt.executeQuery();
			// insert, update, delete => stmt.executeUpdate();
			// 	리턴타입이 몇개의 쿼리가 실행됐는지의 카운트 수
			int cnt = stmt.executeUpdate();
			
			// 6단계 => 받아온 결과값을 처리
			System.out.println(cnt + "개가 정상 입력되었습니다");
			
			// 페이지의 view를 지정한 페이지로 이동시킴
			response.sendRedirect("getEmpList");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			// 7단계 => 사용한 리소스를 닫는다
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
