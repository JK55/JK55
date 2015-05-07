package com.samsung.biz.board.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.samsung.biz.board.vo.BoardVO;
import com.samsung.biz.utils.JDBCUtils;

public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public void addBoard(BoardVO vo, String today){
		
		conn = JDBCUtils.getConnection();
		try {
			String sql = "";
/*			String sql = "INSERT INTO(seq, title, nickname, content, regdate,  userid) board " +
					"VALUES((select nvl(max(seq), 0)+1 from board), ?, ?, ?, SYSDATE, ?)";*/
			
			if(today.equals("")){
				sql = "insert into board(seq, title, nickname, content, regdate, userid) " +
						"values( (select nvl(max(seq), 0)+1 from board), " +
						"?, ?, ?, sysdate, 'guest')";
			} else {
				sql = "insert into board(seq, title, nickname, content, regdate, userid) " +
						"values( (select nvl(max(seq), 0)+1 from board), " +
						"?, ?, ?, ?, 'guest')";
			}
			stmt = conn.prepareStatement(sql);
			
			if(today.equals("")){
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getNickname());
				stmt.setString(3, vo.getContent());
			} else {
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getNickname());
				stmt.setString(3, vo.getContent());
				Date regdate = vo.getRegdate();
				stmt.setDate(4, regdate);
				
			}
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
		
	}
	
	public void updateBoard(BoardVO vo){
		
		conn = JDBCUtils.getConnection();
		
		try {
			
			String sql = "UPDATE board SET title=?, content=? WHERE seq=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
		
		
	}
	
	public void deleteBoard(BoardVO vo){
		
		conn = JDBCUtils.getConnection();
		try {
			String sql = "DELETE FROM board WHERE seq=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
		
	}
	
	// ResultSet 값을 적절히 처리해서 넘겨야 한다
	public BoardVO getBoard(BoardVO vo){
		
		BoardVO board = new BoardVO();
		conn = JDBCUtils.getConnection();
		try {
			String sql = "SELECT * FROM board WHERE seq=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setNickname(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegdate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
				board.setUserid(rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}
		return board;
	}
	
	// 모든 ResultSet 값을 적절히 처리해서 넘겨야 한다
	public ArrayList<BoardVO> getBoardList(BoardVO vo){
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {

			conn = JDBCUtils.getConnection();
			String sql = "";
			
			if(vo.getSearchCondition().equals("TITLE")){
				sql = "SELECT * FROM board WHERE title LIKE '%' || ? || '%'";
			} else if(vo.getSearchCondition().equals("CONTENT")){
				sql = "SELECT * FROM board WHERE content LIKE '%' || ? || '%'";
			}
			
			//모든 row(BoardVO) 객체를 담을 ArrayList

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getSearchKeyword());
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}
		return list;
	}
	
}
