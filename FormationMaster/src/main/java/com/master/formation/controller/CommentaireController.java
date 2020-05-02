package com.master.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.master.formation.dto.CommentaireDto;
import com.master.formation.service.CommentaireService;

@RestController
public class CommentaireController {

	@Autowired
	private CommentaireService commentaireService;

	@GetMapping("/commentaires")
	public List<CommentaireDto> getAll() {
		return commentaireService.getAll();
	}

	@PostMapping("/createcommentaire")
	public CommentaireDto createcommentaire(@RequestBody CommentaireDto commentaireDto) {
		return commentaireService.create(commentaireDto);
	}

	@PostMapping("/updatecommentaire")
	public CommentaireDto updatecommentaire(@RequestBody CommentaireDto commentaireDto) {
		return commentaireService.update(commentaireDto);
	}

	@GetMapping("getcommentaire/{id}")
	public CommentaireDto getcommentaire(@PathVariable(value = "id") long id) {
		return commentaireService.getById(id);
	}

	@GetMapping("deletecommentaire/{id}")
	public void deletecommentaire(@PathVariable(value = "id") long id) {
		commentaireService.deleteById(id);
	}
}
