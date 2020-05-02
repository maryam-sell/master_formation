package com.master.formation.transformer;

import org.dozer.DozerBeanMapper;

import com.master.formation.dto.CommentaireDto;
import com.master.formation.entity.Commentaire;

public class CommentaireTransformer extends GenericTransformer<CommentaireDto, Commentaire> {
	private DozerBeanMapper mapper = new DozerBeanMapper();
	private FormationTransformer formateurTransformer = new FormationTransformer();
	private UserTransformer userTransformer = new UserTransformer();

	@Override
	public Commentaire toEntity(CommentaireDto dto) {
		Commentaire commentaire = mapper.map(dto, Commentaire.class);
		if (dto.getFormation() != null) {
			commentaire.setFormation(formateurTransformer.toEntity(dto.getFormation()));
		}
		if (dto.getUserDto() != null) {
			commentaire.setUser(userTransformer.toEntity(dto.getUserDto()));
		}

		return commentaire;
	}

	@Override
	public CommentaireDto toDto(Commentaire entity) {
		CommentaireDto commentaireDto = mapper.map(entity, CommentaireDto.class);
		if (entity.getFormation() != null) {
			commentaireDto.setFormation(formateurTransformer.toDto(entity.getFormation()));
		}
		if (entity.getUser() != null) {
			commentaireDto.setUserDto(userTransformer.toDto(entity.getUser()));
		}
		return commentaireDto;
	}

}
