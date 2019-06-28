package com.iu.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeServiceImpl;
import com.iu.s6.AbstractTest;

public class DBConnectTest extends AbstractTest{

	@Inject
	private DriverManagerDataSource dataSource;
	
	
	@Test
	public void test() throws Exception {
		
		Connection con = dataSource.getConnection();
		assertNotNull(con);
		//널이 아니었으면 좋겠다
		
	}

}
