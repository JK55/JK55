package com.samsung.board.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.utils.JDBCUtils;

@WebServlet("/updateBoard")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement stmt = null;
		

		try {
			conn = JDBCUtils.getConnection();
			
			// 3단계 => Query 준비
			// PreparedStatement 객체는 쿼리 실행전에 해야 할 일에 대한 메소드를 가지고 있다
			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			// 4단계 => 쿼리에 들어갈 변수들을 세팅 작업
			// ?에 대한 세팅 작업
			stmt.setString(1, "변경 타이틀");
			stmt.setString(2, "변경 내용");
			stmt.setInt(3, 8);
			
			// 5단계 => 쿼리를 실행하고 그 결과값을 받아온다
			// select => stmt.executeQuery();
			// insert, update, delete => stmt.executeUpdate();
			// 	리턴타입이 몇개의 쿼리가 실행됐는지의 카운트 수
			int cnt = stmt.executeUpdate();
			
			// 6단계 => 받아온 결과값을 처리
			System.out.println(cnt + "개가 정상 입력되었습니다");
			
			// 페이지의 view를 지정한 페이지로 이동시킴
			response.sendRedirect("getBoardList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			// 7단계 => 사용한 리소스를 닫는다
			JDBCUtils.close(conn, stmt);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
