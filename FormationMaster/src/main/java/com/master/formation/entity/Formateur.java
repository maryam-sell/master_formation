package com.master.formation.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "formateur", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class Formateur extends User {

	public Formateur() {

	}

	public Formateur(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String adress,
			@NotBlank @Size(max = 120) String phone, Set<Role> roles) {
		super(username, password, email, adress, phone, roles);
		// TODO Auto-generated constructor stub
	}

}
