package com.master.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.formation.entity.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
