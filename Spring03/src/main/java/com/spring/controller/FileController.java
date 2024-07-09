package com.spring.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file/")
public class FileController {
	
	@Autowired
	HttpSession session; 
	@RequestMapping("download")
	public void download(String oriname, String sysname, HttpServletResponse response) throws Exception{
		System.out.println(oriname +" : "+sysname);
		
		String realPath = session.getServletContext().getRealPath("upload");
		File target = new File(realPath+"/"+sysname);
		
		oriname = new String(oriname.getBytes(),"ISO-8859-1");
		response.setHeader("content-disposition", "attachment; filename=\""+oriname+"\"");
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
				DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
			byte[] fileContents = new byte[(int) target.length()];
			dis.readFully(fileContents);
			dos.write(fileContents);
			dos.flush();
		}
	}
}
