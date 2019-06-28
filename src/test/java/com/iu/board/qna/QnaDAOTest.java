package com.iu.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s6.AbstractTest;
import com.iu.util.PageMaker;

public class QnaDAOTest extends AbstractTest{

	@Inject
	private QnaDAOImpl qnaDAOImpl;
	
	@Test
	public void write() {
		
		int result = 0;
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(3);
		qnaDTO.setTitle("title");
		qnaDTO.setWriter("aaa");
		qnaDTO.setContents("fddf");
		try {
			result = qnaDAOImpl.setWrite(qnaDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void update() {
		
		int result = 0;
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("agag");
		qnaDTO.setContents("aaaaa");
		qnaDTO.setNum(3);
		try {
			result = qnaDAOImpl.setUpdate(qnaDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotEquals(0, result);
		
	}
	
	@Test
	public void delete() {
		
		int result = 0;
		try {
			result = qnaDAOImpl.setDelete(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotEquals(1, result);
	}
	
	@Test
	public void selectOne() {
		
		BoardDTO boardDTO = null;
		try {
			boardDTO = qnaDAOImpl.getSelect(3);
			System.out.println(boardDTO.getWriter());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(boardDTO);
	}
	
	@Test
	public void selectList() {
		
//		List<BoardDTO> ar = null;
//		try {
//			ar = qnaDAOImpl.getList(pageMaker);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		assertNotEquals(0, ar.size());
		
	}

}
