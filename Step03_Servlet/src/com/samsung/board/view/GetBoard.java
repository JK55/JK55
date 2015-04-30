package com.samsung.board.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.utils.JDBCUtils;

@WebServlet("/getBoard")
public class GetBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBoard() {
        super();
    }

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
			conn = JDBCUtils.getConnection();
			
			// 3단계 => Query 준비
			// PreparedStatement 객체는 쿼리 실행전에 해야 할 일에 대한 메소드를 가지고 있다
			String sql = "SELECT * FROM board WHERE seq = ?";
			stmt = conn.prepareStatement(sql);
			
			// 4단계 => 쿼리에 들어갈 변수들을 세팅 작업
			// ?에 대한 세팅 작업
			stmt.setInt(1, 1);
			
			// 5단계 => 쿼리를 실행하고 그 결과값을 받아온다
			rs = stmt.executeQuery();
			
			// 6단계 => 받아온 결과값을 처리
			out.println("<h3>사원 목록</h3>");
			while(rs.next()){
				int id = rs.getInt("seq");
				String title = rs.getString("title");
				String nickname = rs.getString("nickname");
				Date regdate = rs.getDate("regdate");
				int cnt = rs.getInt("cnt");
				String userid = rs.getString("userid");
				
				out.println(id+" - "+title+" - "+nickname+" - "+regdate+" - "
						+cnt+" - "+userid+"<br>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// 7단계 => 사용한 리소스를 닫는다
			JDBCUtils.close(conn, stmt, rs);
			
		}
	
		out.println("</body>");
		out.println("</html>");
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
