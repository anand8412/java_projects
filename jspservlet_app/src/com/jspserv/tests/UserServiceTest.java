package com.jspserv.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jspserv.dao.IUserDAO;
import com.jspserv.service.UserService;

public class UserServiceTest {

	@Mock
	IUserDAO userDAO;

	@Before
	public void create() {
		MockitoAnnotations.initMocks(this);
        Mockito.when(userDAO.delete(1)).thenReturn(false);
        Mockito.when(userDAO.delete(4)).thenReturn(true);
	}
	
	@Test
	public void testDelete(){
		UserService userService = new UserService();
		userService.setUserDAO(userDAO);
		assertEquals(userService.delete(1),false);
		assertEquals(userService.delete(4),true);
		
	}

}
