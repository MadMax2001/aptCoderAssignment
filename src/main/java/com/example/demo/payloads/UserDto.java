package com.example.demo.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be atleast of 4 characters.")
	private String Name;
	
	@Email(message = "Email address is not valid !!")
	@NotEmpty(message = "Email is required !!")
	private String Email;
	
	
	@NotEmpty
	@Size(min = 8, max = 20, message = "Password must be min of 8 chars and max of 20 characters.")
	private String Password;
	
	
	@NotEmpty
	private String About;

}
