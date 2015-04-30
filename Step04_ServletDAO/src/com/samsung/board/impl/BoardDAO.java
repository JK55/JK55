package com.samsung.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.samsung.board.utils.JDBCUtils;
import com.samsung.board.vo.BoardVO;

public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public void addBoard(BoardVO vo){

		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "insert into board(seq, title, nickname, content, regdate, userid) " +
					"values( (select nvl(max(seq), 0)+1 from board), " +
					"?, ?, ?, sysdate, 'guest')";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString (2, vo.getNickname());
			stmt.setString(3, vo.getContent());
			
			int cnt = stmt.executeUpdate();
			
			System.out.println(cnt + "개가 정상 입력되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt);
		}

	}
	
	public BoardVO getBoard(BoardVO vo){

		BoardVO board = new BoardVO();

		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "SELECT * FROM board WHERE seq = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			
			if(rs.next()){
			
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		return board;
	}
	
	
	public ArrayList<BoardVO> getBoardList(){
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from board";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				list.add(new BoardVO(rs.getInt("seq"), rs.getString("title"), rs.getString("nickname"), 
						rs.getString("content"), rs.getDate("regdate"), rs.getInt("cnt"), 
						rs.getString("userid")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		
		return list;
		
	}
	
	public BoardVO deleteBoard(BoardVO vo){

		BoardVO board = new BoardVO();

		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "delete from board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 9);
			
			int cnt = stmt.executeUpdate();
			
			System.out.println(cnt + "개가 정상 삭제되었습니다");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		return board;
	}
	
	public BoardVO updateBoard(BoardVO vo){
		
		BoardVO board = new BoardVO();
		
		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "변경 타이틀");
			stmt.setString(2, "변경 내용");
			stmt.setInt(3, 8);
			
			int cnt = stmt.executeUpdate();
			
			System.out.println(cnt + "개가 정상 입력되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			JDBCUtils.close(conn, stmt);
			
		}
		return board;
		
	}
	

}
