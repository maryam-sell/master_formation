package com.master.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.formation.dto.ElementFormationDto;
import com.master.formation.service.ElementService;

@RestController
public class ElementFormationController {

	@Autowired
	private ElementService elementService;

	@GetMapping("/elements")
	public List<ElementFormationDto> getAll() {
		return elementService.getAll();
	}

	@PostMapping("/createelement")
	public ElementFormationDto createelement(@RequestBody ElementFormationDto elementDto) {
		return elementService.create(elementDto);
	}

	@PostMapping("/updateelement")
	public ElementFormationDto updateelement(@RequestBody ElementFormationDto elementDto) {
		return elementService.update(elementDto);
	}

	@GetMapping("getelement/{id}")
	public ElementFormationDto getelement(@PathVariable(value = "id") long id) {
		return elementService.getById(id);
	}

	@GetMapping("deleteelement/{id}")
	public void deleteelement(@PathVariable(value = "id") long id) {
		elementService.deleteById(id);
	}
}
