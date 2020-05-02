package com.master.formation.service;

import java.util.List;

import com.master.formation.dto.FormateurDto;

public interface FormateurService {

	FormateurDto create(FormateurDto formateurDto);

	FormateurDto update(FormateurDto formateurDto);

	FormateurDto getById(Long id);

	void deleteById(Long id);

	List<FormateurDto> getAll();
}
