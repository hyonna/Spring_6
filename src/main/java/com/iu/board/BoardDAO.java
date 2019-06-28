package com.iu.board;

import java.util.List;

public interface BoardDAO {

	//글삭제
	public int setDelete(int num) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;

	//글 등록
	public int setWrite(BoardDTO boardDTO) throws Exception;
	
	//글 리스트 가져오기
	public List<BoardDTO> getList() throws Exception;
	
	//글 하나 가져오기
	public BoardDTO getSelect(int num) throws Exception;
}
