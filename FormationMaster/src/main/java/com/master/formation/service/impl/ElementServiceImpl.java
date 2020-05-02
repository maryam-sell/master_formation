package com.master.formation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.formation.dto.ElementFormationDto;
import com.master.formation.entity.ElementFormation;
import com.master.formation.repository.ElementRepository;
import com.master.formation.service.ElementService;
import com.master.formation.transformer.ElementTransformer;
@Service
public class ElementServiceImpl implements ElementService {

	private Logger log = Logger.getLogger(FormateurServiceImpl.class);
	@Autowired
	private ElementRepository elementRepo;
	private ElementTransformer elementTransformer = new ElementTransformer();

	@Override
	public ElementFormationDto create(ElementFormationDto elementFormationDto) {
		ElementFormationDto elementDtoCreated = null;
		try {
			ElementFormation element = elementTransformer.toEntity(elementFormationDto);
			ElementFormation elementCreated = elementRepo.save(element);
			elementDtoCreated = elementTransformer.toDto(elementCreated);

		} catch (Exception e) {
			log.error("ElementServiceImpl-> create error: " + e.getMessage());
		}
		return elementDtoCreated;
	}

	@Override
	public ElementFormationDto update(ElementFormationDto elementFormationDto) {
		ElementFormationDto elementDtoUpdated = null;
		try {
			ElementFormationDto elementDtoToUpdated = getById(elementFormationDto.getId());
			if (elementDtoToUpdated != null) {
				elementDtoToUpdated.setFormation(elementFormationDto.getFormation());
				elementDtoToUpdated.setName(elementFormationDto.getName());
				elementDtoToUpdated.setNmbParticipants(elementFormationDto.getNmbParticipants());
				elementDtoToUpdated.setPrix(elementFormationDto.getPrix());
				elementDtoToUpdated.setTemps(elementFormationDto.getTemps());
				ElementFormation element = elementTransformer.toEntity(elementDtoToUpdated);
				ElementFormation elementUpdated = elementRepo.save(element);
				elementDtoUpdated = elementTransformer.toDto(elementUpdated);
			}
		} catch (Exception e) {
			log.error("ElementServiceImpl-> create error: " + e.getMessage());
		}
		return elementDtoUpdated;
	}

	@Override
	public ElementFormationDto getById(Long id) {
		ElementFormationDto elementDtoGot = null;
		try {
			Optional<ElementFormation> elementGot = elementRepo.findById(id);
			if (elementGot.isPresent()) {
				elementDtoGot = elementTransformer.toDto(elementGot.get());
			}

		} catch (Exception e) {
			log.error("ElementServiceImpl->getById error: " + e.getMessage());
		}
		return elementDtoGot;
	}

	@Override
	public void deleteById(Long id) {
		try {
			elementRepo.deleteById(id);
		} catch (Exception e) {
			log.error("ElementServiceImpl-> deleteById error: " + e.getMessage());
		}

	}

	@Override
	public List<ElementFormationDto> getAll() {
		List<ElementFormationDto> listElementDto = new ArrayList<ElementFormationDto>();
		try {
			List<ElementFormation> listElement = elementRepo.findAll();
			listElementDto = elementTransformer.toDtoList(listElement);
		} catch (Exception e) {
			log.error("ElementServiceImpl-> getAll error: " + e.getMessage());
		}
		return listElementDto;
	}

}
