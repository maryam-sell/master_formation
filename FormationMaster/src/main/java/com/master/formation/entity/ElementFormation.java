package com.master.formation.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ElementFormation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal prix;
	private int nmbParticipants;
	private int temps;
	@ManyToOne(fetch = FetchType.LAZY)
	private Formation formation;

	public ElementFormation() {

	}

	public ElementFormation(String name, BigDecimal prix, int nmbParticipants, int temps, Formation formation) {
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
}
