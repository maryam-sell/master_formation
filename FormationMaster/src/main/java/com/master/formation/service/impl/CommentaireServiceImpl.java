package com.master.formation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.formation.dto.CommentaireDto;
import com.master.formation.entity.Commentaire;
import com.master.formation.repository.CommentaireRepository;
import com.master.formation.service.CommentaireService;
import com.master.formation.transformer.CommentaireTransformer;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	private Logger log = Logger.getLogger(FormateurServiceImpl.class);
	@Autowired
	private CommentaireRepository commentaireRepo;
	private CommentaireTransformer commentaireTtransfrormer = new CommentaireTransformer();

	@Override
	public CommentaireDto create(CommentaireDto commentaireDto) {
		CommentaireDto commentaireDtoCreated = null;
		try {
			Commentaire commantaire = commentaireTtransfrormer.toEntity(commentaireDto);
			Commentaire commentaireCreated = commentaireRepo.save(commantaire);
			commentaireDtoCreated = commentaireTtransfrormer.toDto(commentaireCreated);
		} catch (Exception e) {
			log.error("CommentaireServiceImpl-> create error: " + e.getMessage());
		}
		return commentaireDtoCreated;
	}

	@Override
	public CommentaireDto update(CommentaireDto commentaireDto) {
		CommentaireDto commentaireDtoUpdated = null;
		try {
			CommentaireDto commentaireDtoToUpdate = getById(commentaireDto.getId());
			if (commentaireDtoToUpdate != null) {
				commentaireDtoToUpdate.setUserDto(commentaireDto.getUserDto());
				commentaireDtoToUpdate.setCommentaire(commentaireDto.getCommentaire());
				commentaireDtoToUpdate.setFormation(commentaireDto.getFormation());

				Commentaire commantaire = commentaireTtransfrormer.toEntity(commentaireDtoToUpdate);
				Commentaire commentaireUpdated = commentaireRepo.save(commantaire);
				commentaireDtoUpdated = commentaireTtransfrormer.toDto(commentaireUpdated);
			}
		} catch (Exception e) {
			log.error("CommentaireServiceImpl-> update error: " + e.getMessage());
		}
		return commentaireDtoUpdated;
	}

	@Override
	public CommentaireDto getById(Long id) {
		CommentaireDto commentaireDtoGot = null;
		try {
			Optional<Commentaire> comentaireGot = commentaireRepo.findById(id);
			if (comentaireGot.isPresent()) {
				commentaireDtoGot = commentaireTtransfrormer.toDto(comentaireGot.get());
			}
		} catch (Exception e) {
			log.error("CommentaireServiceImpl-> getById error: " + e.getMessage());
		}
		return commentaireDtoGot;
	}

	@Override
	public void deleteById(Long id) {
		try {
			commentaireRepo.deleteById(id);
		} catch (Exception e) {
			log.error("CommentaireServiceImpl-> deleteById error: " + e.getMessage());
		}

	}

	@Override
	public List<CommentaireDto> getAll() {
		List<CommentaireDto> listCommentaireDto = new ArrayList<CommentaireDto>();
		try {
			List<Commentaire> listCommentaire = commentaireRepo.findAll();
			listCommentaireDto = commentaireTtransfrormer.toDtoList(listCommentaire);
		} catch (Exception e) {
			log.error("CommentaireServiceImpl-> getAll error: " + e.getMessage());
		}
		return listCommentaireDto;
	}

}
