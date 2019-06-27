package com.iu.board.notice;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s6.AbstractTest;

public class NoticeDAOTest extends AbstractTest {
	
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	@Test
	public void test() throws Exception {
		BoardDTO boardDTO=noticeDAOImpl.getSelect(12);
		assertNotNull(boardDTO);
	}

}
