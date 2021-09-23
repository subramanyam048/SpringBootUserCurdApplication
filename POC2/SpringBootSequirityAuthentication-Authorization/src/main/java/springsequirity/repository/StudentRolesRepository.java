package springsequirity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springsequirity.entity.StudentRole;

@Repository
public interface StudentRolesRepository extends CrudRepository<StudentRole, Long> {

	@Query("select a.role from StudentRole a, Student b where b.userName=?1 and a.studentId=b.studentId")
	public List<String> findRoleByUserName(String userName);

}
