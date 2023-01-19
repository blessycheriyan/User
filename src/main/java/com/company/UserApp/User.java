package com.company.UserApp;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="User_table")
@Data
@AllArgsConstructor(staticName = "build")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank
	@Size(min=3,max=50,message="Name is required with atleast 3 char")
	private String name;
	@PastOrPresent
	private LocalDate birthdate;
	@Email
	
	private String email;
	@NotBlank
	private String address;


	public  User () {}

}
