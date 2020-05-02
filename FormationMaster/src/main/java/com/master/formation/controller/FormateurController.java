package com.master.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.formation.dto.FormateurDto;
import com.master.formation.service.FormateurService;

@RestController
public class FormateurController {
	@Autowired
	private FormateurService formateurService;

	@GetMapping("/formateurs")
	public List<FormateurDto> getAll() {
		return formateurService.getAll();
	}

	@PostMapping("/createformateur")
	public FormateurDto createformateur(@RequestBody FormateurDto formateurDto) {
		return formateurService.create(formateurDto);
	}

	@PostMapping("/updateformateur")
	public FormateurDto updateformateur(@RequestBody FormateurDto formateurDto) {
		return formateurService.update(formateurDto);
	}

	@GetMapping("getformateur/{id}")
	public FormateurDto getformateur(@PathVariable(value = "id") long id) {
		return formateurService.getById(id);
	}

	@GetMapping("deleteformateur/{id}")
	public void deleteformateur(@PathVariable(value = "id") long id) {
		formateurService.deleteById(id);
	}

}
