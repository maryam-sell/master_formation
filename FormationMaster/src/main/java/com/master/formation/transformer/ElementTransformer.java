package com.master.formation.transformer;

import org.dozer.DozerBeanMapper;

import com.master.formation.dto.ElementFormationDto;
import com.master.formation.entity.ElementFormation;

public class ElementTransformer extends GenericTransformer<ElementFormationDto, ElementFormation> {
	private DozerBeanMapper mapper = new DozerBeanMapper();
	private FormationTransformer formateurTransformer = new FormationTransformer();

	@Override
	public ElementFormation toEntity(ElementFormationDto dto) {
		ElementFormation element = mapper.map(dto, ElementFormation.class);
		if (dto.getFormation() != null) {
			element.setFormation(formateurTransformer.toEntity(dto.getFormation()));
		}
		return element;
	}

	@Override
	public ElementFormationDto toDto(ElementFormation entity) {
		ElementFormationDto elementDto = mapper.map(entity, ElementFormationDto.class);
		if (entity.getFormation() != null) {
			elementDto.setFormation(formateurTransformer.toDto(entity.getFormation()));
		}
		return elementDto;
	}

}
