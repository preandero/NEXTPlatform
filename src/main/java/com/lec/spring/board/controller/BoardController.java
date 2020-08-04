package com.lec.spring.board.controller;

import com.lec.spring.board.beans.BWriteDTO;
import com.lec.spring.board.command.*;
import com.lec.spring.board.domain.C;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	
	// MyBatis 
	private SqlSession sqlSession;
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}


	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	@RequestMapping("/list.do")
	public String list(Model model, String category, String page, String col, String word) {
		model.addAttribute("category", category);
		model.addAttribute("page", page);
		model.addAttribute("col", col);
		model.addAttribute("word", word);
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		command = new BCompanyListCommand();
		command.execute(model);
		return "board/write";
	}

	@RequestMapping("/gWrite.do")
	public String gwrite(Model model) {

		return "board/gwrite";
	}
	
	@RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}
	
	@RequestMapping("/view.do")
	public String view(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BViewCommand().execute(model);
		return "board/view";
	}
	
	@RequestMapping("/update.do")
	public String update(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BSelectCommand().execute(model);
		return "board/update";
	}
	
	@RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
	public String updateOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BUpdateCommand().execute(model);
		return "board/updateOk";
	}
	
	@RequestMapping("/deleteOk.do")
	public String deleteOk(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BDeleteCommand().execute(model);
		return "board/deleteOk";
	}
	
	
	
}













