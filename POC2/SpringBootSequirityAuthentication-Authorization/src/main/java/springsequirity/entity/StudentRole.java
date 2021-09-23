package springsequirity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "student_roles")
public class StudentRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_role_id")
	private Long studentroleId;
	@Column(name = "student_id")
	private String studentId;
	@Column(name = "role")
	private String role;

}
