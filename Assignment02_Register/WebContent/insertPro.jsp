<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.samsung.biz.utils.JDBCUtils"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	
	Connection conn = JDBCUtils.getConnection();
	
	String sql = "insert into husers(seq, name, password, email, gender, age) " +
			"values( (select nvl(max(seq), 0)+1 from husers), " +
			"?, ?, ?, ?, ?)";
	
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setString(1, name);
	stmt.setString(2, password);
	stmt.setString(3, email);
	stmt.setString(4, gender);
	stmt.setString(5, age);
	
	stmt.executeUpdate();
	JDBCUtils.close(conn, stmt);
	response.sendRedirect("list.jsp");
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