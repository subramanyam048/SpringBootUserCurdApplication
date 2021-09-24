package springsecurity.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springsecurity.repository.StudentRepository;

import springsecurity.entity.Student;

@Service
public class StudentService implements UserDetailsService, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> findById(String studentId) {
		return studentRepository.findById(studentId);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepository.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(student.getUserName(), student.getPassword(),
				new ArrayList<>());
	}

}
