package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "FileMapper.";
	
	public List<FileDTO> getList(List<FileDTO> files) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"fileList", files);
	}

	public FileDTO getSelect(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"fileSelect", num);
	}
	
	public int setDelete(int num) throws Exception {
		int result = sqlSession.delete(NAMESPACE+"fileDelete", num);
		
		return result;
	}
	
	public int setUpdate(FileDTO fileDTO) throws Exception {
		
		int result = sqlSession.update(NAMESPACE+"fileUpdate", fileDTO);
		
		return result;
	}
	
	public int setWrite(FileDTO fileDTO) throws Exception {
		
		int result = sqlSession.insert(NAMESPACE+"fileWrite", fileDTO);
		
		return result;
	}

}
