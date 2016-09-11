package com.coderwurst.tddwithtestdoubles;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class UserServiceImplTest {

	@Test
	public void testAssignPassword() throws Exception {
		User user = mock(User.class);
		UserDAO userDao = mock(UserDAO.class);
		SecurityService sercurityService = mock(SecurityService.class);
		UserServiceImpl userService = new UserServiceImpl(userDao, sercurityService);
		
		userService.assignPassword(user);
		
		verify(user).getPassword();
		verify(userDao).updateUser(user);
	}
}
