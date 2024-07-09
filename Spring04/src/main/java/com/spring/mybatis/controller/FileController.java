package com.spring.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mybatis.services.FileService;

@Controller
@RequestMapping("/file/")
public class FileController {

	@Autowired
	private FileService fileService;
	
	//msg 텍스트 / file = 파일내용
	@RequestMapping("upload")
	public String upload(String msg, List<MultipartFile> file) throws Exception {
		for(MultipartFile files: file) {
			fileService.upload(msg, files);
		}
			
		//file은 임시경로에 저장되어있으므로 언제 지워져도 이상하지 않음
		//삭제 되기 전에 어딘가의 경로로 이동시켜줘야함
		//웹이랑 관련없는 UUID 코드들은 컨트롤러에 어울리지 않음
		
		return "redirect:/";
	}
}
