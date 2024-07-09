package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.DAO.BoardDAO;
import com.spring.DAO.FileDAO;
import com.spring.DAO.ReplyDAO;
import com.spring.DTO.BoardDTO;
import com.spring.DTO.FileDTO;
import com.spring.DTO.MemberDTO;
import com.spring.DTO.ReplyDTO;
import com.spring.Services.FileService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	public BoardDAO dao;

	@Autowired
	public ReplyDAO replyDao;

	@Autowired
	HttpSession session;

	@Autowired
	private FileService fileService;
	
	@Autowired
	private FileDAO fileDAO;

	@RequestMapping("main")
	public String boardMain() {
		List<BoardDTO> postList = dao.getPostList();
		for (BoardDTO board : postList) {
			System.out.println(board.getTitle());
		}
		session.setAttribute("postList", postList);
		return "board/main";
	}

	@RequestMapping("writeBoard")
	public String writeBoard(BoardDTO board, MultipartFile[] file) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("loginResult");
		String realPath = session.getServletContext().getRealPath("upload");
		System.out.println("realPath: " + realPath);
		System.out.println(member.getId());

		int parentSeq = dao.insertBoard(board, member);
		System.out.println("parentSeq: "+parentSeq);
		for (MultipartFile files : file) {
			fileService.upload(realPath, files, parentSeq);
		}
		return "redirect:/board/main";
	}

	@RequestMapping("showOnePost")
	public String showOnePost(int seq, HttpSession session, Model model) {
		System.out.println(seq);
		BoardDTO onePost = dao.getOnePost(seq);
		List<ReplyDTO> replyList = replyDao.getAllReply(seq);
		for (ReplyDTO reply : replyList) {
			System.out.println(reply.getWrite_date());
		}
		MemberDTO member = (MemberDTO) session.getAttribute("loginResult");
		List<FileDTO> fileList = fileDAO.selectAllByParentSeq(seq);
		if (member == null) {
			return "redirect:/member/login";
		}

		System.out.println("로그인 유저 번호 : " + member.getId());
		session.setAttribute("userSeq", member.getId());
		session.setAttribute("post", onePost);
		session.setAttribute("replyList", replyList);
		session.setAttribute("fileList", fileList);

		model.addAttribute("post", onePost);
		model.addAttribute("userSeq", member.getId());

		return "board/onePost";
	}

	@RequestMapping("writePage")
	public String writePage() {
		return "board/write";
	}

	@RequestMapping("updatePage")
	public String updatePage() {
		BoardDTO board = (BoardDTO) session.getAttribute("post");
		session.setAttribute("post", board);
		return "board/update";
	}

	@RequestMapping("update")
	public String update(BoardDTO board) {
		System.out.println(board.getSeq() + ":" + board.getTitle() + ":" + board.getContents());
		dao.updatePost(board);
		return "redirect:/board/showOnePost?seq=" + board.getSeq();
	}

	@RequestMapping("delete")
	public String delete(int seq) {
		System.out.println(seq);
		dao.deletePost(seq);
		return "redirect:/board/main";
	}
}
