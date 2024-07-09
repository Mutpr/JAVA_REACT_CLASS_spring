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
	
	//msg �ؽ�Ʈ / file = ���ϳ���
	@RequestMapping("upload")
	public String upload(String msg, List<MultipartFile> file) throws Exception {
		for(MultipartFile files: file) {
			fileService.upload(msg, files);
		}
			
		//file�� �ӽð�ο� ����Ǿ������Ƿ� ���� �������� �̻����� ����
		//���� �Ǳ� ���� ����� ��η� �̵����������
		//���̶� ���þ��� UUID �ڵ���� ��Ʈ�ѷ��� ��︮�� ����
		
		return "redirect:/";
	}
}
