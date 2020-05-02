package com.master.formation.dto;

import java.math.BigDecimal;

public class ElementFormationDto {

	private Long id;
	private String name;
	private BigDecimal prix;
	private int nmbParticipants;
	private int temps;
	private FormationDto formation;

	public ElementFormationDto() {

	}

	public ElementFormationDto(String name, BigDecimal prix, int nmbParticipants, int temps, FormationDto formation) {
		super();
		this.name = name;
		this.prix = prix;
		this.nmbParticipants = nmbParticipants;
		this.temps = temps;
		this.formation = formation;
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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getNmbParticipants() {
		return nmbParticipants;
	}

	public void setNmbParticipants(int nmbParticipants) {
		this.nmbParticipants = nmbParticipants;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public FormationDto getFormation() {
		return formation;
	}

	public void setFormation(FormationDto formation) {
		this.formation = formation;
	}
}
