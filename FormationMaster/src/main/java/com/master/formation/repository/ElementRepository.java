package com.master.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.formation.entity.ElementFormation;

public interface ElementRepository extends JpaRepository<ElementFormation, Long> {

}
