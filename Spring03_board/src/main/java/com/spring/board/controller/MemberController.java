package com.spring.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.DAO.MemberDAO;
import com.spring.DTO.MemberDTO;

@Controller
@RequestMapping("/Member/")
public class MemberController {
	
	@Autowired	
	private MemberDAO dao;
	
	@RequestMapping("join")
	public String join() throws Exception{
		return "member/join";
	}
	
	@ResponseBody
	@RequestMapping(value="idCheck", produces="text/html; charset=utf-8")
	public String idCheck(String id) throws Exception{
		boolean result = dao.isIdDuplicated(id);
		System.out.println(result);
		return String.valueOf(result);
	}
	
	@RequestMapping("signup")
	public String insertUser(MemberDTO member) throws Exception {
		dao.insertUser(member);
		return "member/signup";
	}
	
	@RequestMapping("login")
	public String loginUser(MemberDTO DTO) throws Exception{
		boolean loginResult = dao.loginUser(DTO);
		return "member/login";
	}
}
