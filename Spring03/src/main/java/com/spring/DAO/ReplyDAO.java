package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.DTO.ReplyDTO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSession session;
	
	public List<ReplyDTO> getAllReply(int postSeq){
		List<ReplyDTO> replyList = session.selectList("reply.getAllReply");
		return replyList;
	}
	public int insertReply(ReplyDTO reply, int writer_seq, int post_seq) {
		Map<String, Object> paramList = new HashMap<>();
		paramList.put("contents", reply.getContents());
		paramList.put("writer_seq", writer_seq);
		paramList.put("post_seq", post_seq);
		return session.insert("reply.insertReply",paramList);
	}
	
	public void updateReply(ReplyDTO reply) {
		Map<String, Object> paramList = new HashMap<>();
		paramList.put("contents", reply.getContents());
		paramList.put("seq", reply.getSeq());
		session.update("reply.updateReply", paramList);
	}
	
	public void deleteReply(int replySeq) {
		session.delete("reply.deleteReply", replySeq);
	}
}
