package com.master.formation.dto;

import java.util.Set;

import com.master.formation.entity.Role;

public class FormateurDto extends UserDto {

	public FormateurDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormateurDto(String email, String adress, String phone, Set<Role> roles) {
		super(email, adress, phone, roles);
		// TODO Auto-generated constructor stub
	}

}
