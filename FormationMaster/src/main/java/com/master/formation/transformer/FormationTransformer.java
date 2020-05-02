package com.master.formation.transformer;

import org.dozer.DozerBeanMapper;

import com.master.formation.dto.FormationDto;
import com.master.formation.entity.Formation;

public class FormationTransformer extends GenericTransformer<FormationDto, Formation> {
	private DozerBeanMapper mapper = new DozerBeanMapper();
	private UserTransformer userTransformer = new UserTransformer();

	@Override
	public Formation toEntity(FormationDto dto) {
		Formation formation = mapper.map(dto, Formation.class);
		if (dto.getUserDto() != null) {
			formation.setUser(userTransformer.toEntity(dto.getUserDto()));
		}
		return formation;
	}

	@Override
	public FormationDto toDto(Formation entity) {
		FormationDto formationDto = mapper.map(entity, FormationDto.class);
		if (entity.getUser() != null) {
			formationDto.setUserDto(userTransformer.toDto(entity.getUser()));
		}
		return formationDto;
	}

}
