package com.master.formation.dto;

import java.util.HashSet;
import java.util.Set;

import com.master.formation.entity.Role;

public class UserDto {

	private Long id;
	private String username;
	private String password;
	private String email;
	private String adress;
	private String phone;
	private Set<Role> roles = new HashSet<>();

	public UserDto() {
	}

	public UserDto(String username, String password, String email, String adress, String phone, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.roles = roles;
	}

	public UserDto(String email, String adress, String phone, Set<Role> roles) {

		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
