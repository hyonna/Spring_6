package com.iu.member.file;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.file.MemberFileDAO;
import com.iu.file.MemberFileDTO;
import com.iu.s6.AbstractTest;

public class MemberFileDAOTest extends AbstractTest {
	
	@Inject
	private MemberFileDAO memberFileDAO;
	
	
	@Test
	public void write() throws Exception {
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("id");
		memberFileDTO.setFname("fname");
		memberFileDTO.setOname("oname");
		
		int result = memberFileDAO.setWrite(memberFileDTO);
		assertEquals(1, result);
		
	}
	
	

}
