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
import com.spring.DTO.FileDTO;

@Repository
public class FileDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(FileDTO dto) {
		String insertSQL = "insert into files values(files_seq.nextval, ? , ? , ?)";
		KeyHolder key = new GeneratedKeyHolder();
		jdbc.update(new PreparedStatementCreator() {
			//자바 스타일의 콜백함수
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
				PreparedStatement ps = conn.prepareStatement(insertSQL, new String [] {"seq"});				
				//스프링이 직접 만들지 말고 내가 시키는데로 만들어 하고 지정해주는것
				ps.setString(1, dto.getOriname());
				ps.setString(2, dto.getSysname());
				ps.setInt(3, dto.getParent_seq());
				return ps;
				//preparedStatement가 ps를 기준으로 동작함
				
			}
			//쿼리가 실행하면서 발생하는 결과값(row number)을 그대로 꺼내서 Keyholder 에 잡아놓음
			
			//한번에 두개 이상의 데이터에 관련된 작업을 실행할때, 
		}, key);
		
		int seq = key.getKey().intValue();
		System.out.println("seq: "+seq);
		return seq;
	}
	
	public List<FileDTO> selectAllByParentSeq(int parent_Seq){
		String selectAllByParentSeqSQL = "select * from files where parent_seq = ?";
		return jdbc.query(selectAllByParentSeqSQL, new BeanPropertyRowMapper<>(FileDTO.class), parent_Seq);
		
	}
}
