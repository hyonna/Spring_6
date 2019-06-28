package com.iu.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

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
	public int setWrite(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setWrite(boardDTO);
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		
		return qnaDAO.getList();
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {

		return qnaDAO.getSelect(num);
	}

}
