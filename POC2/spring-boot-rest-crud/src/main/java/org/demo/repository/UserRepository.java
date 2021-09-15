package org.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	List<User> findAllByUserName(String userName);

	List<User> findAllByUserBirthDate(Date userbirthDate);

	List<User> findAllByUserJoiningDate(Date userjoiningDate);

	List<User> findAllByUserPinCode(int userPinCode);

	

}
