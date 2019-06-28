package com.iu.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s6.AbstractTest;
import com.iu.util.PageMaker;

public class NoticeServiceTest extends AbstractTest {
	
	@Inject
	private NoticeServiceImpl NoticeServiceImpl;

	@Test
	public void test() throws Exception{
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCurPage(1);
		List<BoardDTO> ar = NoticeServiceImpl.getList(pageMaker);
		
		assertEquals(10, ar.size());
		
	}

}
