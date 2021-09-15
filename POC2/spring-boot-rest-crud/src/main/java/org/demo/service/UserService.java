package org.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.demo.entity.User;
import org.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> findByUserName(String userName) {
		return userRepository.findAllByUserName(userName);
	}
	
	public  List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Iterable<User> findAllSortByBirthDate() {
		return userRepository.findAll(Sort.by(Sort.Direction.ASC, "userBirthDate"));
		
	}
	public Iterable<User> findAllSortByJoiningDate() {
		return  userRepository.findAll(Sort.by(Sort.Direction.ASC, "userJoiningDate"));
	}

	public Optional<User> findById(int userId) {
		return userRepository.findById(userId);
	}

	public void deleteById(int userId) {
		userRepository.deleteById(userId);
	}

	public List<User> finByUserPinCode(int userPinCode) {
		return userRepository.findAllByUserPinCode(userPinCode);
	}


	

}
