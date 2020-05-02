package com.master.formation.dto;

import java.util.Set;

import com.master.formation.entity.Role;

public class BénéficiaireDto extends UserDto {

	public BénéficiaireDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BénéficiaireDto(String email, String adress, String phone, Set<Role> roles) {
		super(email, adress, phone, roles);
		// TODO Auto-generated constructor stub
	}


}
