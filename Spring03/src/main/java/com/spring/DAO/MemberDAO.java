package com.spring.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.DTO.MemberDTO;

@Repository
public class MemberDAO {
	
	//JDBC방식을 의존성 주입받는것부터 스타트
	
	@Autowired
	private SqlSession sqlSessionFactory;
	
	public int insertMember(MemberDTO member) throws Exception {
		KeyHolder key = new GeneratedKeyHolder();
		sqlSessionFactory.insert("Member.insertMember", member);
		
		int seq = key.getKey().intValue();
		System.out.println(seq);
		return seq;
		
	}
	
    public MemberDTO loginUser(String username, String password) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        return sqlSessionFactory.selectOne("Member.loginUser", params);
    }
	
	public List<MemberDTO> selectAll() throws Exception {
		List<MemberDTO> memberList = sqlSessionFactory.selectList("Member.selectAll");
		return memberList;
	}
	
	public MemberDTO selectBySeq(int seq) {
		return sqlSessionFactory.selectOne("Member.selectBySeq", seq);
	}
	
	public int updateBySeq(int seq, String username, String password) {
		Map<String, Object> paramsList = new HashMap<>();
		paramsList.put("username", username);
		paramsList.put("password", password);
		paramsList.put("seq", seq);
		return sqlSessionFactory.update("Member.updateBySeq", paramsList);
	}
	
	public int isIdExist(String username) throws Exception{
		return sqlSessionFactory.selectOne("Member.isIdExist", username);
	}
	
}
