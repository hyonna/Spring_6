package com.iu.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	
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