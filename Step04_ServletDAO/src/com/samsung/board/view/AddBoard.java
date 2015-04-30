package com.samsung.board.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.impl.BoardDAO;
import com.samsung.board.vo.BoardVO;

public class AddBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 타이틀");
		vo.setNickname("새로운 이름");
		vo.setContent("새로운 내용");
		
		BoardDAO dao = new BoardDAO();
		dao.addBoard(vo);
		
		response.sendRedirect("getBoardList");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
