package org.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.demo.entity.User;
import org.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userservice.save(user);
	}

	@GetMapping("/all")
	public Iterable<User> allUser() {
		return userservice.findAll();
	}
	
	@GetMapping("/allSortByUserBirthDate")
	public Iterable<User> allSortbyUserBirthDate() {
		return userservice.findAllSortByBirthDate();
	}
	@GetMapping("/allSortByUserJoiningDate")
	public Iterable<User> allSortbyUserJoiningDate() {
		return userservice.findAllSortByJoiningDate();
	}
	
	@GetMapping("/userName/{userName}")
	public List<User> userByName(@PathVariable("userName") String userName) {
		return userservice.findByUserName(userName);
	}
	
	@GetMapping("/userPinCode/{userPinCode}")
	public List<User> userByPincode(@PathVariable("userPinCode") int userPinCode) {
		return userservice.finByUserPinCode(userPinCode);
	}
	

	@GetMapping("/{userId}")
	public Optional<User> userById(@PathVariable("userId") int userId) {
		return userservice.findById(userId);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userservice.save(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		userservice.deleteById(userId);
	}

	
}
