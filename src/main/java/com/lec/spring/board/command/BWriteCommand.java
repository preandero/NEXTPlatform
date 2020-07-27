package com.lec.spring.board.command;

import java.util.Map;

import com.lec.spring.board.beans.BWriteDTO;
import com.lec.spring.board.beans.IWriteDAO;
import com.lec.spring.board.domain.C;
import org.springframework.ui.Model;



public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
//		BWriteDAO dao = new BWriteDAO();
//		int result = dao.insert(dto);
//		model.addAttribute("result", result);
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.insert(dto));
		System.out.println(dto.getUid());
	
		System.out.println(dto.getRegDate());
//		model.addAttribute("result", dao.insert(dto.getSubject(), dto.getContent(), dto.getName()));
	}

}











