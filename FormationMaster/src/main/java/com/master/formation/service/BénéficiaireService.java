package com.master.formation.service;

import java.util.List;

import com.master.formation.dto.BénéficiaireDto;

public interface BénéficiaireService {

	BénéficiaireDto create(BénéficiaireDto bénéficiaireDto);

	BénéficiaireDto update(BénéficiaireDto bénéficiaireDto);

	BénéficiaireDto getById(Long id);

	void deleteById(Long id);

	List<BénéficiaireDto> getAll();
}
