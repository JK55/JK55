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

@WebServlet("/deleteBoard")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement stmt = null;
		

		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "delete from board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 9);
			
			int cnt = stmt.executeUpdate();
			
			System.out.println(cnt + "개가 정상 삭제되었습니다");
			
			response.sendRedirect("getBoardList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
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
