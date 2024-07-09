package com.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.DTO.BoardDTO;
import com.spring.DTO.MemberDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insertBoard(BoardDTO board, MemberDTO member) {
		String insertBoardSQL = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate)";
		KeyHolder key = new GeneratedKeyHolder();
		jdbc.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
				PreparedStatement ps = conn.prepareStatement(insertBoardSQL, new String [] {"seq"});	
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContents());
				ps.setInt(3, board.getWriter_seq());
				return ps;
			}
		}, key);
		
		int seq = key.getKey().intValue();
		System.out.println(seq);
		return seq;
				
	}
	
	public List<BoardDTO> getPostList(){
		String getPostListSQL = "select * from board";
		return jdbc.query(getPostListSQL, new BeanPropertyRowMapper<>(BoardDTO.class));
	}
	
	public BoardDTO getOnePost(int seq) {
		String getOnePostSQL = "select * from board where seq = ?";
		return jdbc.queryForObject(getOnePostSQL, new BeanPropertyRowMapper<>(BoardDTO.class), seq);
	}
	
	public void updatePost(BoardDTO board) {
	    String updatePostSQL = "update board set title=?, contents=? where seq=?";
	    jdbc.update(updatePostSQL, board.getTitle(), board.getContents(), board.getSeq());
	}
	
	public void deletePost(int seq) {
		String deletePostSQL = "delete from board where seq = ?";
		jdbc.update(deletePostSQL, seq);
	}

}
