package com.hruser.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HRUser {
	
@Id
private String userName;
private String firstName;
private String middleName;
private String lastName;
@Email
private String email;
private String phoneNumber;
}
