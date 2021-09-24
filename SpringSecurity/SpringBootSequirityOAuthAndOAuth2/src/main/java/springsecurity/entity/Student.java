package springsecurity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "students_data")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private String studentId;
	@Column(name = "student_userName")
	private String userName;
	@Column(name = "student_password")
	private String mobileNumber;
	@Column(name = "student_mobileNumber")
	private String password;
	@Column(name = "student_email")
	private String email;
	@OneToMany(targetEntity = Project.class)
	@Column(name = "student_projects")
	private List<Project> projects;

}
