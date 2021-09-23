package springsecurity.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springsequirity.entity.Student;
import springsequirity.service.StudentDetailsService;

@RestController
public class StudentController<userName, Password> {

	@Autowired
	private StudentDetailsService userDetailsService;

	@GetMapping("/getAll")
	public Iterable<Student> getallStudent() {
		return userDetailsService.getAllStudents();

	}

	@GetMapping("/{studentId}")
	public Optional<Student> userById(@PathVariable("studentId") String studentId) {
		return userDetailsService.findById(studentId);

	}

	@PostMapping("/login/user/admin")
	public String login(@RequestBody userName username, @RequestBody Password password) {
		return login(username, password);

	}

	@GetMapping("/home")
	public String homePage() {
		return homePage();
	}

}
