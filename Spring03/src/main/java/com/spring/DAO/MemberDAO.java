package com.spring.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.DTO.MemberDTO;

@Repository
public class MemberDAO {
	
	//JDBC방식을 의존성 주입받는것부터 스타트
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(MemberDTO member) throws Exception {
		String insertSQL = "insert into member values(member_seq.nextval, ?, ?, ?)";
		return jdbc.update(insertSQL, member.getUsername(),  member.getPassword(), member.getName());
		
	}
	
	public MemberDTO loginUser(MemberDTO member) throws Exception{
		String loginUserSQL = "select * from member where username = ? and password =?";
		return jdbc.queryForObject(loginUserSQL,  new BeanPropertyRowMapper<>(MemberDTO.class), member.getUsername(), member.getPassword());
	}
	
	public List<MemberDTO> selectAll() throws Exception {
		String selectAllSQL = "select * from member";
		return jdbc.query(selectAllSQL, new BeanPropertyRowMapper<>(MemberDTO.class));
	}
	
	public MemberDTO selectBySeq(int seq) {
		String selectBySeqSQL = "select * from member where seq = ?";
		return jdbc.queryForObject(selectBySeqSQL, new BeanPropertyRowMapper<>(MemberDTO.class),seq);
	}
	
	public int updateBySeq(int seq, String username, String password, String name) {
		String updatedBySeqSQL = "update member set username = ? and password = ? where id = ?";
		return jdbc.update(updatedBySeqSQL, new BeanPropertyRowMapper<>(MemberDTO.class), seq);
	}
	
	public boolean isIdExist(String id) throws Exception{
		String isIdExistSQL = "select count(*) from member where username = ?";
		return jdbc.queryForObject(isIdExistSQL, Boolean.class, id);
	}
	
}
