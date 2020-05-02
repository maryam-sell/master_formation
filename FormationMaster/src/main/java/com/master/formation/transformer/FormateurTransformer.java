package com.master.formation.transformer;

import org.dozer.DozerBeanMapper;

import com.master.formation.dto.FormateurDto;
import com.master.formation.entity.Formateur;

public class FormateurTransformer extends GenericTransformer<FormateurDto, Formateur> {

	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public Formateur toEntity(FormateurDto dto) {
		Formateur formateur=mapper.map(dto, Formateur.class);
		return formateur;
	}

	@Override
	public FormateurDto toDto(Formateur entity) {
		FormateurDto formateurDto = mapper.map(entity, FormateurDto.class);
		return formateurDto;
	}


}
