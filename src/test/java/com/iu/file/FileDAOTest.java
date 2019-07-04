package com.iu.file;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.iu.s6.AbstractTest;

public class FileDAOTest extends AbstractTest{

	@Inject
	private FileDAO fileDAO;
	private FileDTO fileDTO;
	
	//@Before
	public void ready() {
		
		fileDTO = new FileDTO();
		fileDTO.setNum(1);
		fileDTO.setFname("fname");
		fileDTO.setOname("oname");
		
	}
	
	@Test
	public void write() throws Exception {
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(100);
		fileDTO.setFname("fname");
		fileDTO.setOname("oname");
		
		FileDTO fileDTO2 = new FileDTO();
		fileDTO2.setNum(100);
		fileDTO2.setFname("fname1");
		fileDTO2.setOname("oname1");
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		files.add(fileDTO);
		files.add(fileDTO2);
		
		int result = fileDAO.setWrite(files);
		System.out.println("Test Done");
		//assertEquals(1, result);
	}
	
	//@Test
	public void update() throws Exception {
		
		int result = fileDAO.setUpdate(fileDTO);
		assertEquals(0, result);
	}
	
	//@Test
	public void delete() throws Exception {
		int reuslt = fileDAO.setDelete(0);
	}
	
	//@Test
	public void select() throws Exception {
		
		
	}
	
	//@Test
	public void selectList() throws Exception {
		
		
	}
	
}
