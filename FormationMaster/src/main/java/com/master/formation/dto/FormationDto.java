package com.master.formation.dto;

import java.util.Date;

public class FormationDto {

	private Long id;

	private String name;
	private String objectif;
	private String etablissement;
	private Date date;
	private UserDto userDto;

	public FormationDto() {

	}

	public FormationDto(String name, String objectif, String etablissement, Date date,UserDto userDto) {
		super();
		this.name = name;
		this.objectif = objectif;
		this.etablissement = etablissement;
		this.date = date;
		this.userDto = userDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	

}
