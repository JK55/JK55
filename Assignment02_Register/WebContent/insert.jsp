<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="insertPro.jsp">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="0">남
					<input type="radio" name="gender" value="1">여
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="age"></td>
			</tr>
		</table>
		<input type="submit" value="가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>