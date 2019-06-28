package com.iu.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;

@Repository
public class NoticeDAOImpl implements BoardDAO {
	
	
	
	@Inject
	private SqlSession sqlSession;
	private String mapper = "NoticeMapper.";
	
	

	@Override
	public int setDelete(int num) throws Exception {
		int result = sqlSession.delete(mapper+"noticeDelete", num);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.update(mapper+"noticeUpdate", boardDTO);
		
		return result;
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.insert(mapper+"noticeWrite", boardDTO);
										//mapper + "id" 	//파라미터로 넘길값
		return result;
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapper+"noticeList");
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		
		return sqlSession.selectOne(mapper+"noticeSelect", num);
	}
	
	
	
	
	
	
	
	
	
//	@Inject
//	private DriverManagerDataSource dataSource;
//	
//	
//
//	@Override
//	public int setDelete(int num) throws Exception {
//		Connection con = dataSource.getConnection();
//		String sql = "delete notice where num=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		int result = st.executeUpdate();
//		st.close();
//		con.close();
//		return result;
//	}
//
//	@Override
//	public int setUpdate(BoardDTO boardDTO) throws Exception {
//		Connection con =dataSource.getConnection();
//		String sql = "update notice set title=?, writer=?, contents=? from notice where num=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getWriter());
//		st.setString(3, boardDTO.getContents());
//		int result = st.executeUpdate();
//		st.close();
//		con.close();
//		return result;
//	}
//
//	@Override
//	public int setWrite(BoardDTO boardDTO) throws Exception {
//		Connection con  = dataSource.getConnection();
//		String sql = "insert into notice values (notice_seq.nextval, ?, ?, ?, sysdate, 0)";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getWriter());
//		st.setString(3,  boardDTO.getContents());
//		int result = st.executeUpdate();
//		st.close();
//		con.close();
//		return result;
//	}
//
//	@Override//? extends BoardDTO : boardDTO와 boardDTO를 상속받는 것들을 담겠다. ? super NoticeDTO 와 noticeDTO의 부모 타입을 담으세요.
//	public List<BoardDTO> getList() throws Exception {
//		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
//		Connection con = dataSource.getConnection();
//		String sql ="select * from (select rownum r, n.* from (select num, title, writer, reg_date, hit from notice) n) "
//				+ " where r between ? and ? order by r desc"; // where r between ? and ? order by r desc
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, 1);
//		st.setInt(2, 10);
//		ResultSet rs = st.executeQuery();
//		while(rs.next()) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			noticeDTO.setNum(rs.getInt("num"));
//			noticeDTO.setTitle(rs.getString("title"));
//			noticeDTO.setWriter(rs.getString("writer"));
//			noticeDTO.setReg_date(rs.getDate("reg_date"));
//			noticeDTO.setHit(rs.getInt("hit"));
//			ar.add(noticeDTO);
//		}
//		rs.close();
//		st.close();
//		con.close();
//		return ar;
//	}
//
//	@Override
//	public BoardDTO getSelect(int num) throws Exception {
//		Connection con = dataSource.getConnection();
//		NoticeDTO noticeDTO = null;
//		String sql = "select * from notice where num =?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		ResultSet rs = st.executeQuery();
//		if(rs.next()) {
//			noticeDTO = new NoticeDTO();
//			noticeDTO.setNum(rs.getInt("num"));
//			noticeDTO.setTitle(rs.getString("title"));
//			noticeDTO.setWriter(rs.getString("writer"));
//			noticeDTO.setContents(rs.getString("contents"));
//			noticeDTO.setReg_date(rs.getDate("reg_date"));
//			noticeDTO.setHit(rs.getInt("hit"));
//		}
//		rs.close();
//		st.close();
//		con.close();
//		return noticeDTO;
//	}

}
