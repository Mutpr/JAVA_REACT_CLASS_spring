package com.spring.mybatis.services;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mybatis.dao.FileDAO;
import com.spring.mybatis.dto.FileDTO;

@Service
public class FileService {

	@Autowired
	private FileDAO dao;

	public void upload(String realPath, MultipartFile file) throws Exception {
		File realPathFile = new File(realPath);

		String oriname = file.getOriginalFilename();
		String sysname = UUID.randomUUID() + "_" + oriname;

		// 서버에서 browse deployment path 찾을수 있음
		if (!realPathFile.exists()) {
			realPathFile.mkdir();
			file.transferTo(new File(realPath + "/" + sysname));
			
			dao.insert(new FileDTO(0, oriname, sysname, 0));

		}

	}
}
