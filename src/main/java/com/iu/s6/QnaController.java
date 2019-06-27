package com.iu.s6;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDTO;
import com.iu.board.qna.QnaService;

@Controller
@RequestMapping("/qna/")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	
	@RequestMapping(value = "qnaSelect", method = RequestMethod.GET)
	public ModelAndView getSelect(ModelAndView mv, int num) {
		BoardDTO qnaDTO = new QnaDTO();
		try {
			qnaDTO=qnaService.getSelect(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("dto", qnaDTO);
		mv.addObject("board", "qna");
		mv.setViewName("/board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		try {
			ar=qnaService.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
		mv.setViewName("/board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView setWrite2(ModelAndView mv, BoardDTO boardDTO) {
		int result=0;
		try {
			result = qnaService.setWrite(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.setViewName("redirect:./qnaWrite");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView setWrite(ModelAndView mv, BoardDTO boardDTO) {
		mv.addObject("board", "qna");
		mv.setViewName("/board/boardWrite");
		return mv;
	}
	
	
}
