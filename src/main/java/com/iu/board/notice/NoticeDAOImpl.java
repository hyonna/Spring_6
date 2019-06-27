package com.iu.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;

@Repository
public class NoticeDAOImpl implements BoardDAO {
	
	@Inject
	private DBConnector dbConnector;
	

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		Connection con  = dbConnector.getConnect();
		String sql = "insert into notice values (notice_seq.nextval, ?, ?, ?, sysdate, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3,  boardDTO.getContents());
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}

	@Override//? extends BoardDTO : boardDTO와 boardDTO를 상속받는 것들을 담겠다. ? super NoticeDTO 와 noticeDTO의 부모 타입을 담으세요.
	public List<BoardDTO> getList() throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = dbConnector.getConnect();
		String sql ="select * from (select rownum r, n.* from (select num, title, writer, reg_date, hit from notice) n) "
				+ " where r between ? and ? order by r desc"; // where r between ? and ? order by r desc
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, 1);
		st.setInt(2, 10);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		con.close();
		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		Connection con = dbConnector.getConnect();
		NoticeDTO noticeDTO = null;
		String sql = "select * from notice where num =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
		}
		rs.close();
		st.close();
		con.close();
		return noticeDTO;
	}

}
