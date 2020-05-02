package com.master.formation.service;

import java.util.List;

import com.master.formation.dto.ElementFormationDto;

public interface ElementService {

	ElementFormationDto create(ElementFormationDto elementFormationDto);

	ElementFormationDto update(ElementFormationDto elementFormationDto);

	ElementFormationDto getById(Long id);

	void deleteById(Long id);

	List<ElementFormationDto> getAll();
}
