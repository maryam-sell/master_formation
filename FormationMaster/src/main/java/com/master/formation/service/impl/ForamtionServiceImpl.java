package com.master.formation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.formation.dto.FormationDto;
import com.master.formation.entity.Formation;
import com.master.formation.repository.FormationRepository;
import com.master.formation.service.FormationService;
import com.master.formation.transformer.FormationTransformer;

@Service
public class ForamtionServiceImpl implements FormationService {

	private Logger log = Logger.getLogger(FormateurServiceImpl.class);
	@Autowired
	private FormationRepository formationRepo;
	private FormationTransformer formationTransformer = new FormationTransformer();

	@Override
	public FormationDto create(FormationDto formationDto) {
		FormationDto formationDtoCreated = null;
		try {
			Formation formation = formationTransformer.toEntity(formationDto);
			Formation formationCreated = formationRepo.save(formation);
			formationDtoCreated = formationTransformer.toDto(formationCreated);

		} catch (Exception e) {
			log.error("FormationServiceImpl-> create error: " + e.getMessage());
		}
		return formationDtoCreated;

	}

	@Override
	public FormationDto update(FormationDto formationDto) {
		FormationDto formationDtoUpdated = null;
		try {
			FormationDto formationDtoToUpdate = getById(formationDto.getId());
			if (formationDtoToUpdate != null) {
				formationDtoToUpdate.setDate(formationDto.getDate());
				formationDtoToUpdate.setEtablissement(formationDto.getEtablissement());
				formationDtoToUpdate.setUserDto(formationDto.getUserDto());
				formationDtoToUpdate.setName(formationDto.getName());
				formationDtoToUpdate.setObjectif(formationDto.getObjectif());
				Formation formation = formationTransformer.toEntity(formationDtoToUpdate);
				Formation formationUodated = formationRepo.save(formation);
				formationDtoUpdated = formationTransformer.toDto(formationUodated);
			}

		} catch (Exception e) {
			log.error("FormationServiceImpl-> update error: " + e.getMessage());
		}
		return formationDtoUpdated;
	}

	@Override
	public FormationDto getById(Long id) {
		FormationDto formationDtoGot = null;
		try {
			Optional<Formation> formationGot = formationRepo.findById(id);
			if (formationGot.isPresent()) {
				formationDtoGot = formationTransformer.toDto(formationGot.get());
			}

		} catch (Exception e) {
			log.error("FormationServiceImpl-> getById error: " + e.getMessage());
		}
		return formationDtoGot;
	}

	@Override
	public void deleteById(Long id) {
		try {
			formationRepo.deleteById(id);
		} catch (Exception e) {
			log.error("FormationServiceImpl-> deleteById error: " + e.getMessage());
		}

	}

	@Override
	public List<FormationDto> getAll() {
		List<FormationDto> listFormationDto = new ArrayList<FormationDto>();
		try {
			List<Formation> listFormation = formationRepo.findAll();
			listFormationDto = formationTransformer.toDtoList(listFormation);

		} catch (Exception e) {
			log.error("FormationServiceImpl-> getAll error: " + e.getMessage());
		}
		return listFormationDto;
	}

}
