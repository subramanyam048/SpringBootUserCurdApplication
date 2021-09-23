package org.springboot.entity;

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
@Table(name = "student_data")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private String id;
	@Column(name = "student_firstname")
	private String firstname;
	@Column(name = "studentlastname")
	private String lastname;
	@Column(name = "student_email")
	private String email;
	@OneToMany(targetEntity = Project.class)
	@Column(name = "student_projects")
	private List<Project>projects;

}
