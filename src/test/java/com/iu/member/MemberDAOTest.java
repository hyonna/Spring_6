package com.iu.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s6.AbstractTest;

public class MemberDAOTest  extends AbstractTest{
	
	@Inject
	private MemberDAO memberDAO;
	
	@Test
	public void loginTest() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("iu");
		memberDTO = memberDAO.getSelect(memberDTO);
		System.out.println(memberDTO.getEmail());
		System.out.println(memberDTO.getMemberFileDTO().getFname());
		
	}
	
	//@Test
	public void write() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id");
		memberDTO.setPw("pw");
		
		memberDTO = memberDAO.getSelect(memberDTO);
		
		assertNotNull(memberDTO);
		
	}
	
	//@Test
	public void test() {
		
		assertNotNull(memberDAO);
	}

}
