package com.spring.mybatis.dao;

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

import com.spring.mybatis.dto.FileDTO;

@Repository
public class FileDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert(FileDTO dto) {
		String insertSQL = "insert into files values(files_seq.nextval, ? , ? , 0)";
		KeyHolder key = new GeneratedKeyHolder();
		jdbc.update(new PreparedStatementCreator() {
			//�ڹ� ��Ÿ���� �ݹ��Լ�
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
				PreparedStatement ps = conn.prepareStatement(insertSQL, new String [] {"seq"});				
				//�������� ���� ������ ���� ���� ��Ű�µ��� ����� �ϰ� �������ִ°�
				ps.setString(1, dto.getOriname());
				ps.setString(2, dto.getSysname());
				return ps;
				//preparedStatement�� ps�� �������� ������
				
			}
			//������ �����ϸ鼭 �߻��ϴ� �����(row number)�� �״�� ������ Keyholder �� ��Ƴ���
			
			//�ѹ��� �ΰ� �̻��� �����Ϳ� ���õ� �۾��� �����Ҷ�, 
		}, key);
		
		int seq = key.getKey().intValue();
		System.out.println(seq);
		return seq;
	}
	public List<FileDTO> selectAll() throws Exception {
		String selectAllSQL = "select * from files";
		return jdbc.query(selectAllSQL, new BeanPropertyRowMapper<>(FileDTO.class));
	}
}
