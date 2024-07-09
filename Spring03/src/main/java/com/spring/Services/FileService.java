package com.spring.Services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.DAO.FileDAO;
import com.spring.DTO.FileDTO;

@Service
public class FileService {
	@Autowired
	private FileDAO dao;
	
	@Autowired
	HttpSession session;

	public void upload(String realPath, MultipartFile file, int parentSeq) throws Exception {
		System.out.println("file: "+file.toString());
		File realPathFile = new File(realPath);

		String oriname = file.getOriginalFilename();
		String sysname = UUID.randomUUID() + "_" + oriname;

		// 서버에서 browse deployment path 찾을수 있음
		if (!realPathFile.exists()) {
			realPathFile.mkdir();}
			file.transferTo(new File(realPath + "/" + sysname));
			
			dao.insert(new FileDTO(0, oriname, sysname, parentSeq));
	}
	

}
