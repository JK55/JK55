package com.samsung.board.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.impl.BoardDAO;
import com.samsung.board.vo.BoardVO;

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
		
		BoardVO vo = new BoardVO();
		vo.setSeq(3);

		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(vo);
		
		out.println(board.getSeq()+" - "+board.getTitle()+" - "+board.getNickname()+" - "+board.getContent()
				+" - "+board.getRegdate()+" - "+board.getCnt());
		
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
