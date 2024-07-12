package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.DTO.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession session;
	
	public int insertBoard(BoardDTO board) {
		KeyHolder key = new GeneratedKeyHolder();
		session.insert("board.insertBoard", board);
		
		int seq = key.getKey().intValue();
		System.out.println(seq);
		return seq;
				
	}
	
	public List<BoardDTO> getPostList(){
		return session.selectList("board.getPostList");
	}
	
	public BoardDTO getOnePost(int seq) {
		Map<String, Object> params = new HashMap<>();
		params.put("seq", seq);
		return session.selectOne("board.getOnePost", seq);
	}
	
	public int updatePost(BoardDTO board) {
//	    String updatePostSQL = "update board set title=?, contents=? where seq=?";
//	    jdbc.update(updatePostSQL, board.getTitle(), board.getContents(), board.getSeq());
		return session.update("board.updatePost", board);
	}
//	
	public int deletePost(int seq) {
//		String deletePostSQL = "delete from board where seq = ?";
//		jdbc.update(deletePostSQL, seq);
		return session.delete("board.deletePost", seq);
	}

}
