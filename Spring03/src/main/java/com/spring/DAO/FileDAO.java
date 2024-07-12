package com.spring.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.DTO.FileDTO;


@Repository
public class FileDAO {
//	
	@Autowired
	private SqlSession session;

//	
	public int insert(FileDTO file) throws Exception{
		KeyHolder key = new GeneratedKeyHolder();
		session.insert("file.insertFile", file);
		
		int seq = key.getKey().intValue();
		System.out.println(seq);
		return seq;
	}
	
	
	public List<FileDTO> selectAllByParentSeq(int parent_seq){
		List<FileDTO> fileList = session.selectList("file.selectAllByParentSeq", parent_seq);
		return fileList;
	}
	
	

}
//}
