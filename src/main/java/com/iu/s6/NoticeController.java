package com.iu.s6;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeSelect")
	public ModelAndView getSelect(ModelAndView mv, int num) {
		BoardDTO boardDTO = null;
		try {
			boardDTO = new BoardDTO();
			boardDTO=noticeService.getSelect(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mv.setViewName("/board/boardSelect");
		mv.addObject("board", "notice");
		mv.addObject("dto", boardDTO);
		return mv;
	}
	
	@RequestMapping(value = "noticeList")
	public ModelAndView getList(ModelAndView mv) {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		try {
			ar=noticeService.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("/board/boardList");
		mv.addObject("list", ar);
		mv.addObject("board", "notice");
		return mv;
	}

	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView setWrite(ModelAndView mv) {
		mv.setViewName("/board/boardWrite");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView setWrite2(ModelAndView mv, BoardDTO boardDTO) {
		//매개변수에 BoardDTO를 선언해줌으로써 자동으로 정보가 들어간다.
		try {
			int result=noticeService.setWrite(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("redirect:./noticeList");
		return mv;
	}
	
}
