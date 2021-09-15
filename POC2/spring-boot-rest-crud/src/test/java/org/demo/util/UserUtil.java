package org.demo.util;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.demo.entity.User;

public class UserUtil {

	private static final Long currentdate = 1631627364649L;

	public static User getUser() {
		User user = new User(101, "subbu", "singanamala", 516127, new Date(currentdate), new Date(currentdate));
		return user;
	}

	public static List<User> getUserList() {
		User user = new User(101, "subbu", "singanamala", 516127, new Date(currentdate), new Date(currentdate));
		User user1 = new User(102, "subbu12", "singanamala2", 516132, new Date(currentdate), new Date(currentdate));
		return Arrays.asList(user, user1);
	}

}
