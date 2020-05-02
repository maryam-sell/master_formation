package com.master.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.formation.dto.BénéficiaireDto;
import com.master.formation.service.BénéficiaireService;

@RestController
public class BénéficiaireController {

	@Autowired
	BénéficiaireService bénéficiaireService;

	@GetMapping("/bénéficiaires")
	public List<BénéficiaireDto> getAll() {
		return bénéficiaireService.getAll();
	}

	@PostMapping("/createbénéficiaire")
	public BénéficiaireDto createbénéficiaire(@RequestBody BénéficiaireDto bénéficiaireDto) {
		return bénéficiaireService.create(bénéficiaireDto);
	}

	@PostMapping("/updatebénéficiaire")
	public BénéficiaireDto updatebénéficiaire(@RequestBody BénéficiaireDto bénéficiaireDto) {
		return bénéficiaireService.update(bénéficiaireDto);
	}

	@GetMapping("getbénéficiaire/{id}")
	public BénéficiaireDto getbénéficiaire(@PathVariable(value = "id") long id) {
		return bénéficiaireService.getById(id);
	}

	@GetMapping("deletebénéficiaire/{id}")
	public void deletebénéficiaire(@PathVariable(value = "id") long id) {
		bénéficiaireService.deleteById(id);
	}
}
