package springsequirity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springsequirity.entity.Student;
import springsequirity.repository.StudentRepository;
import springsequirity.repository.StudentRolesRepository;

@Service("StudentDetailsService")
public class StudentDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentRolesRepository studentRolesRepository;

	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> findById(String studentId) {
		return studentRepository.findById(studentId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepository.findByUserName(username);
		if (null == student) {
			throw new UsernameNotFoundException("No student present with username:" + username);
		} else {
			List<String> studentRoles = studentRolesRepository.findRoleByUserName(username);
			return new studentDetails(student, studentRoles);
		}

	}

	

}
