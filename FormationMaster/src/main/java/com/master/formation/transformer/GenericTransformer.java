package com.master.formation.transformer;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericTransformer <DTO, ENTITY> {

	public abstract ENTITY toEntity(DTO dto);

	public abstract DTO toDto(ENTITY entity);

	public List<ENTITY> toEntityList(List<DTO> listDto) {

		List<ENTITY> listEntity = new ArrayList<ENTITY>();
		for (DTO dto : listDto) {
			listEntity.add(toEntity(dto));
		}
		return listEntity;
	}
	
	public List<DTO> toDtoList(List<ENTITY> listEntity){
		
		List<DTO> listDto = new ArrayList<DTO>();
		for(ENTITY entity:listEntity) {
			listDto.add(toDto(entity));
		}
		return listDto;
	}

}
