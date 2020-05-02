package com.master.formation.transformer;

import org.dozer.DozerBeanMapper;

import com.master.formation.dto.BénéficiaireDto;
import com.master.formation.entity.Bénéficiaire;

public class BénéficiaireTransformer extends GenericTransformer<BénéficiaireDto, Bénéficiaire> {

	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public Bénéficiaire toEntity(BénéficiaireDto dto) {
		Bénéficiaire bénéficiaire = mapper.map(dto, Bénéficiaire.class);
		return bénéficiaire;
	}

	@Override
	public BénéficiaireDto toDto(Bénéficiaire entity) {
		BénéficiaireDto bénéficiaireDto = mapper.map(entity, BénéficiaireDto.class);

		return bénéficiaireDto;
	}

}
