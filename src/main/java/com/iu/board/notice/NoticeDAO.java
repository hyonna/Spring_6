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
public class NoticeDAO implements BoardDAO {
	
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

	@Override
	public List<BoardDTO> getList() throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = dbConnector.getConnect();
		String sql ="select * from (select rownum r, n.* from (select num, title, writer, reg_date, hit from notice) n) "
				+ " order by r desc"; // where r between 1 and 10 order by r desc
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setHit(rs.getInt("hit"));
			ar.add(boardDTO);
		}
		rs.close();
		st.close();
		con.close();
		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		Connection con = dbConnector.getConnect();
		BoardDTO boardDTO = null;
		String sql = "select * from notice where num =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setHit(rs.getInt("hit"));
		}
		rs.close();
		st.close();
		con.close();
		return boardDTO;
	}

}
