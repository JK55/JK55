<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.samsung.biz.utils.JDBCUtils"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = JDBCUtils.getConnection();
	
	String sql = "select * from husers";
	PreparedStatement stmt = conn.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>email</th>
			<th>성별</th>
			<th>나이</th>
		</tr>
<%
	while(rs.next()){
		
%>		
		<tr>
			<td><%=rs.getString("name") %></td>
			<td><%=rs.getString("email") %></td>
			<td>
			<%
				if(rs.getString("gender").equals("0")){ %>
					<%="male" %>
				<% } else { %>
					<%="female" %>
				<%} %>
			
			</td>
			<td><%=rs.getString("age") %></td>
		</tr>
<%
	}
%>	
	</table>

</body>
</html>