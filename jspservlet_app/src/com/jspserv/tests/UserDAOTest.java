package com.jspserv.tests;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jspserv.dao.UserDAO;
import com.jspserv.model.User; 

public class UserDAOTest {

	@Mock
	DataSource mockDataSource;
	@Mock
	Connection mockConn;
	@Mock
	PreparedStatement mockPreparedStmnt;
	@Mock
	ResultSet mockResultSet;
	int userId = 100;

	@Before
	public void create() throws SQLException {
		MockitoAnnotations.initMocks(this);
		doNothing().when(mockConn).commit();
		when(mockConn.prepareStatement(anyString())).thenReturn(mockPreparedStmnt);
		doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
		when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
		when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
		when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
		when(mockResultSet.getInt("abc")).thenReturn(userId);

	}
	
	@Test
    public void testCreateWithNoExceptions() throws SQLException {

        UserDAO instance = new UserDAO();
        instance.setConn(mockConn);
        instance.insert(new User());

        //verify and assert
        verify(mockConn, times(1)).prepareStatement(anyString());
        verify(mockPreparedStmnt, times(6)).setString(anyInt(), anyString());
        verify(mockPreparedStmnt, times(1)).execute();
        verify(mockConn, times(1)).commit();
        verify(mockResultSet, times(2)).next();
        verify(mockResultSet, times(1)).getInt("abc");
    }

}
