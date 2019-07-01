package com.iu.s6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeDTO;
import com.iu.board.notice.NoticeServiceImpl;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Inject
	private NoticeServiceImpl noticeService;
	
	//select
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public String getSelect(Model model, @RequestParam(defaultValue = "0", required = false)int num) throws Exception {
		
		BoardDTO boardDTO = noticeService.getSelect(num);
		String view = "common/messageMove";
		
		if(boardDTO != null) {
			view = "board/boardSelect";
			model.addAttribute("board", "notice");
			model.addAttribute("dto", boardDTO);
		} else {
			
			model.addAttribute("message", "No Contents");
			model.addAttribute("path", "./noticeList");
		}
		
		return view;
	}
	
	
//	//select
//	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
//	public ModelAndView getSelect(ModelAndView mv, @RequestParam(defaultValue = "0", required = false)int num) throws Exception {
//		BoardDTO boardDTO=noticeService.getSelect(num);
//		mv.setViewName("board/boardSelect");
//		mv.addObject("board", "notice");
//		mv.addObject("dto", boardDTO);
//		return mv;
//	}
	
	
	//List
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView getList(PageMaker pageMaker, ModelAndView mv) throws Exception {
		//매개변수에 모델을 사용했을 경우
		//model.addAttribute("list", ar);
		//return "board/boardList";
//		List<BoardDTO> ar=noticeService.getList();
//		mv.setViewName("board/boardList");
//		mv.addObject("list", ar);
//		mv.addObject("board", "notice");
		
		List<BoardDTO> ar = noticeService.getList(pageMaker);
		mv.addObject("list", ar);
		mv.addObject("pager", pageMaker);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	
	//delete
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public String setDelete(Model model, @RequestParam(defaultValue = "0", required = false)int num) throws Exception {
		
		int result = noticeService.setDelete(num);
		String view = "common/messageMove";
		
		if(result>0) {
			
			view = "redirect:./noticeList";
			
			
		} else {
			
			model.addAttribute("message", "Delete Fail");
			model.addAttribute("path", "./noticeList");
		}
		
		return view;
	}
	

	//update
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		String view="common/messageMove";
		if(result>0) {
			view = "redirect:./noticeList";
		}else {
			model.addAttribute("message", "Update Fail");
			model.addAttribute("path", "./noticeList");
		}
		return view;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String setUpdate(int num, Model model)throws Exception{
		BoardDTO boardDTO = noticeService.getSelect(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	
	//write
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView setWrite(ModelAndView mv) throws Exception{
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "notice");
		return mv;
	}
	
	// 파일 보내기
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String setWrite(Model model, BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception {
		
		//매개변수에 BoardDTO를 선언해줌으로써 자동으로 정보가 들어간다.
		int result=noticeService.setWrite(boardDTO, f1, session);
		String view = "common/messageMove";
		
		if(result>0) {
			
			view = "redirect:./noticeList";
		
			
		} else {
			
			model.addAttribute("message", "Write Fail");
			model.addAttribute("path", "./noticeList");
		}
		
		return view;
	}
	
}
