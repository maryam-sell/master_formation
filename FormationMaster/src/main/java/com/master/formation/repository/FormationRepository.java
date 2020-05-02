package com.master.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.formation.entity.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

}
