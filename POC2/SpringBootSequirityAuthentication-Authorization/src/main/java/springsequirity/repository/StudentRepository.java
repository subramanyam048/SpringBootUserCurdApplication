package springsequirity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springsequirity.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

	public Student findByUserName(String username);
}
