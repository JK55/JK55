<%@page import="com.samsung.biz.board.impl.BoardDAO"%>
<%@page import="com.samsung.biz.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%

	// GetBoard ������ board��� �̸����� request�� ��Ƴ��� ���� �������� �̵������Ƿ�
	// request���� board��� �̸����� ����� �����Ͱ� ����Ǿ� �ִ�
	BoardVO board = (BoardVO)request.getAttribute("board");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ��</title>
</head>

<body>
	<center>
		<h3>�� ��</h3>
		<h3>${sessionScope.name }�� �α��� ȯ���մϴ�...... <a
				href="logout">Log-out</a>
		</h3>
		<hr>
		<form action="updateBoard" method="post">

			<!-- �� ��Ҷ� �ʿ��� ���� form ��Ҹ� ���� �Ѱܾ� �Ѵ� -->
			<input name="seq" type="hidden" value="${board.seq}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>����</td>
					<td align="left"><input name="title" type="text"
						value="${board.title}" /></td>
				</tr>
				<tr>
					<td>�ۼ���</td>
					<td align="left">${board.nickname }%></td>
				</tr>
				<tr>
					<td>����</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
							${board.content }
						</textarea></td>
				</tr>
				<tr>
					<td>�����</td>
					<td align="left">${board.regdate }</td>
				</tr>
				<tr>
					<td>��ȸ��</td>
					<td align="left">${board.cntS }</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="�� ����" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="addBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp; <a
			href="deleteBoard?seq=${board.seq }">�ۻ���</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList">�۸��</a>
	</center>
</body>
</html>

