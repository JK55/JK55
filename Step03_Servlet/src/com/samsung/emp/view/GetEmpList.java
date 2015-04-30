package com.samsung.emp.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/getEmpList", 
				"/getList1"
		}, 
		initParams = { 
				@WebInitParam(name = "name", value = "ȫ�浿"), 
				@WebInitParam(name = "age", value = "20")
		})
public class GetEmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//응답 페이지의 파일 형식과 언어 타입을 설정해야 한글이 안깨짐
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Employee List</title>");
		out.println("</head>");
		out.println("<body>");

		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 1단계 => 사용할 클래스를 올리자
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계 => 디비 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3단계 => Query 준비
			// PreparedStatement 객체는 쿼리 실행전에 해야 할 일에 대한 메소드를 가지고 있다
			String sql = "SELECT * FROM emp";
			stmt = conn.prepareStatement(sql);
			
			// 4단계 => 쿼리에 들어갈 변수들을 세팅 작업
			
			// 5단계 => 쿼리를 실행하고 그 결과값을 받아온다
			rs = stmt.executeQuery();
			
			// 6단계 => 받아온 결과값을 처리
			
			out.println("<h3>사원 목록</h3>");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				Date hire = rs.getDate("hire");
				int salary = rs.getInt("salary");
				double commission = rs.getDouble("commission");
				int did = rs.getInt("did");
/*				System.out.println(id+"\t"+name+"\t"+password+"\t"+hire+"\t"
						+salary+"\t"+commission+"\t"+did);*/
				out.println(id+" - "+name+" - "+password+" - "+hire+" - "
						+salary+" - "+commission+" - "+did+"<br>");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// 7단계 => 사용한 리소스를 닫는다
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		
		//out.println("김제경 천재");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
