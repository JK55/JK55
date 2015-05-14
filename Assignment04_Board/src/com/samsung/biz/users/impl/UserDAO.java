package com.samsung.biz.users.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.samsung.biz.users.vo.UserVO;
import com.samsung.biz.utils.JDBCUtils;

public class UserDAO {
	 
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public UserVO login(UserVO vo){
		UserVO user = null;
		try {
			
			conn = JDBCUtils.getConnection();
			String sql = "SELECT * FROM users WHERE id=? AND password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if(rs.next()){
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}
		return user;
	}

}
