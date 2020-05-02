package com.master.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.formation.dto.FormationDto;
import com.master.formation.service.FormationService;

@RestController
public class FormationController {
	@Autowired
	private FormationService formationService;

	@GetMapping("/formations")
	public List<FormationDto> getAll() {
		return formationService.getAll();
	}

	@PostMapping("/createformation")
	public FormationDto createformation(@RequestBody FormationDto formationDto) {
		return formationService.create(formationDto);
	}

	@PostMapping("/updateformation")
	public FormationDto updateformation(@RequestBody FormationDto formationDto) {
		return formationService.update(formationDto);
	}

	@GetMapping("getformation/{id}")
	public FormationDto getformation(@PathVariable(value = "id") long id) {
		return formationService.getById(id);
	}

	@GetMapping("deleteformation/{id}")
	public void deleteformation(@PathVariable(value = "id") long id) {
		formationService.deleteById(id);
	}

}
