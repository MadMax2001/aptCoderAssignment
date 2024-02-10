package com.example.demo.entities;
//import java.util.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_data")
@NoArgsConstructor
@Getter
@Setter
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="user_name",nullable=false,length=50)
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private String about;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
	joinColumns= @JoinColumn(name="user",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id")
			)
	private Set<Role> roles= new HashSet<>();
	
}
