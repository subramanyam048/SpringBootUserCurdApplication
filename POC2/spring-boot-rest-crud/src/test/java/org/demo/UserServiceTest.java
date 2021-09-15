package org.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.demo.entity.User;
import org.demo.repository.UserRepository;
import org.demo.service.UserService;
import org.demo.util.UserUtil;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	public void findAllTest() throws Exception {
		
		 when(userRepository.findAll()).thenReturn(Arrays.asList(UserUtil.getUser()));


		List<User> users = userService.findAll();

		assertEquals(1, users.size());
		verify(userRepository, times(1)).findAll();
	}
	@Test
	private void findById (int userId) throws Exception {
		when(userRepository.findById(101)).thenReturn(Optional.of(Arrays.asList(UserUtil.getUser())));
		Optional<User>users = userService.findById(userId) ;
		assertEquals(101, users.get());
		verify(userRepository, times(101)).findById(101);
		
	}
 	
	
	
	
	
	
	
	
	
	
	
	

}
