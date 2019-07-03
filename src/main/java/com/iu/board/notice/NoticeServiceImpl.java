package com.iu.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class NoticeServiceImpl implements BoardService {
	
	@Inject
	private NoticeDAOImpl noticeDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;
	

	@Override
	public int setDelete(int num) throws Exception {
		return noticeDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		//파일을 하드디스크에 저장
		//notice 테이블에 저장
		//num을 받아와서
		//files 테이블에 저장
		int result = noticeDAO.setWrite(boardDTO);
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		
		String path = session.getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()) {
			
			file.mkdirs();
		}
		
		for (MultipartFile multipartFile : multipartFiles) {
			
			String fname = fileSaver.saveFile3(path, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			//fileDAO.setWrite(fileDTO);
			files.add(fileDTO);
		}
		
		fileDAO.setWrite(files);
		
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		
		pageMaker.makeRow();
		int totalCount = noticeDAO.getTotalCount(pageMaker);
		
		//페이징 처리하는 계산
		pageMaker.makePage(totalCount);
		
		return noticeDAO.getList(pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		
		return noticeDAO.getSelect(num);
	}

}
