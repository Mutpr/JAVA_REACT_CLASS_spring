package com.spring.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.DTO.ReplyDTO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<ReplyDTO> getAllReply(int postSeq){
		String getAllReplySQL = "select * from reply where post_seq=?";
		return jdbc.query(getAllReplySQL, new BeanPropertyRowMapper<>(ReplyDTO.class), postSeq);
	}
	public int insertReply(ReplyDTO reply, int userSeq, int postSeq) {
		System.out.println(userSeq);
		System.out.println(postSeq);
		String insertReplySQL = "insert into reply values(reply_seq.nextval, ?, ?, sysdate, ?)";
		return jdbc.update(insertReplySQL, reply.getContents(), userSeq, postSeq);
	}
	
	public void updateReply(ReplyDTO reply) {
	    String updateReplySQL = "update reply set contents = ? where seq=?";
	    jdbc.update(updateReplySQL, reply.getContents(), reply.getSeq());
	}
	
	public void deleteReply(int replySeq) {
		String deleteReplySQL = "delete reply where seq = ?";
		jdbc.update(deleteReplySQL, replySeq);
	}
}
