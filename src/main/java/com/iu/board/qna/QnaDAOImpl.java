package com.iu.board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;

@Repository
public class QnaDAOImpl implements BoardDAO {
	
	
	@Inject
	private SqlSession sqlSession;
	private String mapper = "QnaMapper.";

	@Override
	public int setDelete(int num) throws Exception {
		return sqlSession.delete(mapper+"noticeDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(mapper+"qnaUpdate", boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(mapper+"qnaWrite", boardDTO);
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapper+"qnaList");
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapper+"qnaSelect", num);
	}
	
	
	
	
	
//	@Inject
//	private DBConnector dbConnector;
//	
//	
//
//	@Override
//	public int setDelete(int num) throws Exception {
//		Connection con = dbConnector.getConnect();
//		String sql = "delete qna where num=?";
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
//		Connection con = dbConnector.getConnect();
//		String sql = "update qna set title=?, writer=?, contents=?, ref=?, step=?, depth=? from qna where";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, boardDTO.getTitle());
//		st.setString(2, boardDTO.getWriter());
//		st.setString(3, boardDTO.getContents());
//		int result = st.executeUpdate();
//		st.close();
//		con.close();
//		
//		return result;
//	}
//
//	@Override
//	public int setWrite(BoardDTO boardDTO) throws Exception {
//		Connection con = dbConnector.getConnect();
//		String sql = "insert into qna values (qna_seq.nextval, ?, ?, ?, sysdate, 0, qna_seq.currval, 0, 0)";
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
//	public List<BoardDTO> getList() throws Exception {
//		List<BoardDTO> ar = new ArrayList<BoardDTO>();
//		Connection con = dbConnector.getConnect();
//		String sql = "select * from (select rownum r, q.* from "
//				+ " (select num, title, writer, reg_date, hit, ref, step, depth from qna) q) order by r desc";
//		PreparedStatement st = con.prepareStatement(sql);
//		ResultSet rs = st.executeQuery();
//		while(rs.next()) {
//			QnaDTO qnaDTO = new QnaDTO();
//			qnaDTO.setNum(rs.getInt("num"));
//			qnaDTO.setTitle(rs.getString("title"));
//			qnaDTO.setWriter(rs.getString("writer"));
//			qnaDTO.setReg_date(rs.getDate("reg_date"));
//			qnaDTO.setHit(rs.getInt("hit"));
//			qnaDTO.setRef(rs.getInt("ref"));
//			qnaDTO.setStep(rs.getInt("step"));
//			qnaDTO.setDepth(rs.getInt("depth"));
//			ar.add(qnaDTO);
//		}
//		rs.close();
//		st.close();
//		con.close();
//		return ar;
//	}
//
//	@Override
//	public BoardDTO getSelect(int num) throws Exception {
//		Connection con = dbConnector.getConnect();
//		QnaDTO qnaDTO = null;
//		String sql = "select num, title, writer, contents, hit, reg_date from qna where num=?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, num);
//		ResultSet rs = st.executeQuery();
//		if(rs.next()) {
//			qnaDTO = new QnaDTO();
//			qnaDTO.setNum(rs.getInt("num"));
//			qnaDTO.setTitle(rs.getString("title"));
//			qnaDTO.setWriter(rs.getString("writer"));
//			qnaDTO.setContents(rs.getString("contents"));
//			qnaDTO.setReg_date(rs.getDate("reg_date"));
//			qnaDTO.setHit(rs.getInt("hit"));
//		}
//		rs.close();
//		st.close();
//		con.close();
//		return qnaDTO;
//	}

}
