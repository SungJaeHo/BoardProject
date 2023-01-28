package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board*")
public class BoardController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
	
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);
	}
	// �Խù� �ۼ�
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
	
	//�Խù� �ۼ�
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception{
		service.write(vo );
		
		return "redirect:/board/list";
	}
	
	//�Խù� ��ȸ�� get �޼���
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		log.info("ffff"+vo);
		model.addAttribute("view", vo);
	}
	
	
	//�Խù� ����
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
		
	}
	
	//�Խù� ����
	@RequestMapping(value ="/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception{
		service.modify(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	}

}
