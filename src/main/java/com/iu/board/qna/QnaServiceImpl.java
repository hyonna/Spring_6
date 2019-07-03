package com.iu.board.qna;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.PageMaker;

@Service
public class QnaServiceImpl implements BoardService {

	@Inject
	private QnaDAOImpl qnaDAO;
	
	
	
	@Override
	public int setDelete(int num) throws Exception {
		
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {

		return qnaDAO.setUpdate(boardDTO);
	}

	
	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.makeRow();
		
		return qnaDAO.getList(pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {

		return qnaDAO.getSelect(num);
	}

}
