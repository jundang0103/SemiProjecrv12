package mjs.spring.mvc.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mjs.spring.mvc.service.BoardService;
import mjs.spring.mvc.vo.BoardVO;

@Controller
public class BoardController {
	
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	//bean클래스로 정의한 경우 @Autowired 어노테이션 생략 가능 
	@Autowired
	private BoardService bsrv;

	@GetMapping("/list")
	public String list() {
		
		return "board/list";
	}
	
	@GetMapping("/view")
	public String view() {
		
		return "board/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}	
	
	@PostMapping("/write")
	public String writeok(BoardVO bvo) {
		bsrv.newBoard(bvo);
		
		return "redirect:/list";
	}	
	
}
