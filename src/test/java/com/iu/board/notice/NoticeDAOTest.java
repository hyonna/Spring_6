package com.iu.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s6.AbstractTest;
import com.iu.util.PageMaker;


public class NoticeDAOTest extends AbstractTest {
	
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	@Before
	//테스트 메서드가 각각 실행전 한번씩 실행
	public void t() {}
	
	@BeforeClass
	//전체테스트를 시작하기전에 딱 한번 실행
	public static void t2() {}
	
	@After
	//테스트 메서드를 각각 실행 후 한번씩 실행
	public void t3() {}
	
	@AfterClass
	//전체테스트를 다 끝내고 난 후 딱 한번 실행
	public static void t4() {}
	
	
	
	//@Test 
	public void test2() {}
	
	//@Test
	public void selectList() throws Exception {
		
//		List<BoardDTO> ar = noticeDAOImpl.getList(pageMaker);
//		assertNotEquals(15, ar.size());
		
	}
	
	
	//@Test
	public void getTotalCount() throws Exception{
		
		
//		int result = noticeDAOImpl.getTotalCount(pageMaker);
//		
//		assertEquals(15, result);
	}
	
	
	
	//@Test
	public void selectOne() throws Exception{
		
		BoardDTO boardDTO = noticeDAOImpl.getSelect(4);
		System.out.println(boardDTO.getTitle());
		
		assertNotNull(boardDTO);
	}
	
	
	//@Test
	public void getCount() throws Exception {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setKind("1");
		pageMaker.setSearch("h");
		int result = noticeDAOImpl.getTotalCount(pageMaker);
		
		assertEquals(15, result);
		
	}
	
	@Test
	public void test() throws Exception {
//		BoardDTO boardDTO=noticeDAOImpl.getSelect(12);
//		int result =  noticeDAOImpl.setDelete(3);
		
		
		  boardDTO.setTitle("aaa");
		  boardDTO.setWriter("ccccc"); 
		  boardDTO.setContents("abab");
		  int result = noticeDAOImpl.setWrite(boardDTO);
		  
		  assertEquals(1, result);
		 
	}

}
