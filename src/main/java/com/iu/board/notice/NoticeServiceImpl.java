package com.iu.board.notice;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.PageMaker;

@Service
public class NoticeServiceImpl implements BoardService {
	
	@Inject
	private NoticeDAOImpl noticeDAO;
	

	@Override
	public int setDelete(int num) throws Exception {
		return noticeDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		
		
		
		return noticeDAO.setWrite(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		
		pageMaker.makeRow();
		int totalCount = noticeDAO.getTotalCount(pageMaker);
		
		//페이징 처리하는 계산
		pageMaker.makePage(totalCount);
		
		return noticeDAO.getList(pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		
		return noticeDAO.getSelect(num);
	}

}
