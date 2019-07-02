package com.iu.file;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "MemberFileMapper.";
	
	
	public int getNum() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}
	
	public int setWrite(MemberFileDTO memberFileDTO) throws Exception {
		
		int result = sqlSession.insert(NAMESPACE+"setWrite", memberFileDTO);
		
		return result;
	}
	
	
	public MemberFileDTO getSelect(String id) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getSelect", id);
	}

}
