package com.iu.s6;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeServiceImpl;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Inject
	private NoticeServiceImpl noticeService;
	
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView getSelect(ModelAndView mv, @RequestParam(defaultValue = "0", required = false)int num) throws Exception {
		BoardDTO boardDTO=noticeService.getSelect(num);
		mv.setViewName("board/boardSelect");
		mv.addObject("board", "notice");
		mv.addObject("dto", boardDTO);
		return mv;
	}
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) throws Exception {
		//매개변수에 모델을 사용했을 경우
		//model.addAttribute("list", ar);
		//return "board/boardList";
		List<BoardDTO> ar=noticeService.getList();
		mv.setViewName("board/boardList");
		mv.addObject("list", ar);
		mv.addObject("board", "notice");
		return mv;
	}

	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView setWrite(ModelAndView mv) {
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView setWrite(ModelAndView mv, BoardDTO boardDTO) throws Exception {
		//매개변수에 BoardDTO를 선언해줌으로써 자동으로 정보가 들어간다.
		int result=noticeService.setWrite(boardDTO);
		
		mv.setViewName("redirect:./noticeList");
		return mv;
	}
	
}
