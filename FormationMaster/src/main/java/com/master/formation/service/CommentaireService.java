package com.master.formation.service;

import java.util.List;

import com.master.formation.dto.CommentaireDto;

public interface CommentaireService {

	CommentaireDto create(CommentaireDto commentaireDto);

	CommentaireDto update(CommentaireDto commentaireDto);

	CommentaireDto getById(Long id);

	void deleteById(Long id);

	List<CommentaireDto> getAll();
}
