<%@page import="com.samsung.biz.board.impl.BoardDAO"%>
<%@page import="com.samsung.biz.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// post로 넘어왔을때 한글 처리
	//request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));

	// DAO에서 처리
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(seq);
	
	BoardDAO dao = new BoardDAO();
	dao.updateBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>