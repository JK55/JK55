package com.samsung.board.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.impl.BoardDAO;
import com.samsung.board.vo.BoardVO;

public class GetBoardList extends HttpServlet {
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

		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList();
		
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i).getSeq()+" - "+list.get(i).getTitle()+" - "+list.get(i).getNickname()
					+" - "+list.get(i).getRegdate()+" - "+list.get(i).getCnt()+" - "+list.get(i).getUserid()
					+"<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
