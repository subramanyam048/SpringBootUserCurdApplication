package org.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


 @Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = " user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private int userId;
	
	@Column(name = "User_Name")
	private String userName;
	
	@Column(name = "User_SurName")
	private String userSurName;
	
	@Column(name = "User_PinCode")
	private int userPinCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "User_BirthDate")
	private Date userBirthDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "User_JoiningDate")
	private Date userJoiningDate;

}
