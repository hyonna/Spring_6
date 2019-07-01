package com.iu.file;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s6.AbstractTest;

public class FileDAOTest extends AbstractTest{

	@Inject
	private FileDAO fileDAO;
	
	@Test
	public void write() throws Exception {
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(1);
		fileDTO.setFname("aaa.jpg");
		fileDTO.setOname("abab.jpg");
		
		int result = fileDAO.setWrite(fileDTO);
		
		assertEquals(1, result);
		
	}
	
}
