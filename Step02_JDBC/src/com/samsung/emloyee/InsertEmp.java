package com.samsung.emloyee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertEmp {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 1단계 => 사용할 클래스를 올리자
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계 => 디비 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3단계 => Query 준비
			// PreparedStatement 객체는 쿼리 실행전에 해야 할 일에 대한 메소드를 가지고 있다
			String sql = "insert into emp(id, name, password, hire, salary, commission, did) " +
					"values((select nvl(max(id), 0)+1 from emp), ?, ?, sysdate, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			// 4단계 => 쿼리에 들어갈 변수들을 세팅 작업
			// ?에 대한 세팅 작업
			stmt.setString(1, "Im");
			stmt.setString(2, "123");
			stmt.setInt(3, 5000);
			stmt.setDouble(4, 0.05);
			stmt.setInt(5, 100);
			
			// 5단계 => 쿼리를 실행하고 그 결과값을 받아온다
			// select => stmt.executeQuery();
			// insert, update, delete => stmt.executeUpdate();
			// 	리턴타입이 몇개의 쿼리가 실행됐는지의 카운트 수
			int cnt = stmt.executeUpdate();
			
			// 6단계 => 받아온 결과값을 처리
			System.out.println(cnt + "개가 정상 입력되었습니다");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			// 7단계 => 사용한 리소스를 닫는다
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
	
	
}
