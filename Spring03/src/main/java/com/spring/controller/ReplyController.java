package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.DAO.ReplyDAO;
import com.spring.DTO.ReplyDTO;


@Controller
@RequestMapping("/reply/")
public class ReplyController {
	
	@Autowired
	ReplyDAO dao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("insert")
	public String insertReply(ReplyDTO reply, int userSeq, int postSeq) {
		int result = dao.insertReply(reply, userSeq, postSeq);
		System.out.println(result);
		return "redirect:/board/main";
	}
	
	@RequestMapping("update")
	public String updateReply(ReplyDTO reply) {
		dao.updateReply(reply);
		return "redirect:/board/main";
	}
	
	@RequestMapping("delete")
	public String deleteReply(int replySeq) {
		dao.deleteReply(replySeq);
		return "redirect:/board/main";
	}
	
	
}
