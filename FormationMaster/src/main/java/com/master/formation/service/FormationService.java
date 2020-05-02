package com.master.formation.service;

import java.util.List;

import com.master.formation.dto.FormationDto;

public interface FormationService {

	FormationDto create(FormationDto formationDto);

	FormationDto update(FormationDto formationDto);

	FormationDto getById(Long id);

	void deleteById(Long id);

	List<FormationDto> getAll();
}
