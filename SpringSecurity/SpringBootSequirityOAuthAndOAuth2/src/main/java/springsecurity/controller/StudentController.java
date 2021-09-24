package springsecurity.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springsecurity.entity.Student;
import springsecurity.service.StudentService;

@RestController
@RequestMapping(name = "/student")
public class StudentController {

	
	@Autowired
	private StudentService userDetailsService;

	@GetMapping("/getAll")
	public Iterable<Student> getallStudent() {
		return userDetailsService.getAllStudents();

	}

	@GetMapping("/{studentId}")
	public Optional<Student> userById(@PathVariable("studentId") String studentId) {
		return userDetailsService.findById(studentId);
	}

	
	
}
