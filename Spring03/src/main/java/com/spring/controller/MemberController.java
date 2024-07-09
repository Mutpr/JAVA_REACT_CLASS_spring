package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.DAO.MemberDAO;
import com.spring.DTO.MemberDTO;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberDAO dao;

	@Autowired
	HttpSession session;

	@RequestMapping("join")
	public String join() throws Exception {
		return "member/join";
	}

	@ResponseBody
	@RequestMapping(value = "idCheck", produces = "text/html; charset=utf-8")
	public String idCheck(String id) throws Exception {
		boolean result = dao.isIdExist(id);
		System.out.println(result);
		return String.valueOf(result);
	}

	@RequestMapping("signupPage")
	public String signupPage(MemberDTO member) throws Exception {
		return "member/signup";
	}
	
	@RequestMapping("signup")
	public String signup(MemberDTO member) throws Exception {
		System.out.println(member.getName());
		dao.insert(member);
		return "redirect:/";
	}
	
	@RequestMapping("loginPage")
	public String loginPage() {
		return "member/login";
	}

	@RequestMapping("login")
	public String loginUser(String username, String password) throws Exception {
		System.out.println("username:"+username);
		MemberDTO member = new MemberDTO(username, password);
		MemberDTO loginResult = dao.loginUser(member);
		session.setAttribute("loginResult", loginResult);
		
		return "redirect:/";
	}
}
