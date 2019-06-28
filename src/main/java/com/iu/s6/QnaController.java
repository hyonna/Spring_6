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
import com.iu.board.qna.QnaServiceImpl;
import com.iu.util.PageMaker;

@Controller
@RequestMapping("/qna/")
public class QnaController {

	@Inject
	private QnaServiceImpl qnaService;
	
	
	//select
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
	
	//List
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView getList(PageMaker pageMaker) {
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
	
	
	//delete
	@RequestMapping(value = "qnaDelete", method = RequestMethod.GET)
	public ModelAndView setDelete(ModelAndView mv, int num) {
		int result = 0;
		try {
			result = qnaService.setDelete(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.setViewName("redirect:./qnaUpdate");
		}
		
		return mv;
	}
	
	
	//update
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView setUpdate2(ModelAndView mv, BoardDTO boardDTO) {
		
		int result = 0;
		
		try {
			result = qnaService.setUpdate(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.setViewName("redirect:./qnaUpdate");
		}
		
		return mv;
		
	}
	
	
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView setUpdate(ModelAndView mv, BoardDTO boardDTO) {
		
		mv.addObject("board", "qna");
		mv.setViewName("/board/boardUpdate");
		
		return mv;
		
	}
	
	
	
	
	//write
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
