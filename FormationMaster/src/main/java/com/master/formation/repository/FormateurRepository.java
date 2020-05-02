package com.master.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.formation.entity.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {

}
