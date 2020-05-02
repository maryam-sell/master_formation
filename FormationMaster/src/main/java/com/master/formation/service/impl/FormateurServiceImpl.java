package com.master.formation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.formation.dto.FormateurDto;
import com.master.formation.entity.Formateur;
import com.master.formation.repository.FormateurRepository;
import com.master.formation.service.FormateurService;
import com.master.formation.transformer.FormateurTransformer;

@Service
public class FormateurServiceImpl implements FormateurService {

	private Logger log = Logger.getLogger(FormateurServiceImpl.class);
	@Autowired
	private FormateurRepository formaterRepo;
	private FormateurTransformer formateurTransformer = new FormateurTransformer();

	@Override
	public FormateurDto create(FormateurDto formateurDto) {
		FormateurDto formateurDtoCreated = null;
		try {
			Formateur formateur = formateurTransformer.toEntity(formateurDto);
			Formateur formateurCreated = formaterRepo.save(formateur);
			formateurDtoCreated = formateurTransformer.toDto(formateurCreated);

		} catch (Exception e) {
			log.error("FormateurServiceImpl-> create error: " + e.getMessage());
		}
		return formateurDtoCreated;
	}

	@Override
	public FormateurDto update(FormateurDto formateurDto) {
		FormateurDto formateurDtoUpdated = null;
		try {
			FormateurDto formateurDtoToUpdate = getById(formateurDto.getId());
			if (formateurDtoToUpdate != null) {
				formateurDtoToUpdate.setAdress(formateurDto.getAdress());
				formateurDtoToUpdate.setEmail(formateurDto.getEmail());
				formateurDtoToUpdate.setPassword(formateurDto.getPassword());
				formateurDtoToUpdate.setPhone(formateurDto.getPhone());
				formateurDtoToUpdate.setRoles(formateurDto.getRoles());
				formateurDtoToUpdate.setUsername(formateurDto.getUsername());
				Formateur formateur = formateurTransformer.toEntity(formateurDtoToUpdate);
				Formateur formateurUpdated = formaterRepo.save(formateur);
				formateurDtoUpdated = formateurTransformer.toDto(formateurUpdated);
			}
		} catch (Exception e) {
			log.error("FormateurServiceImpl-> create error: " + e.getMessage());
		}
		return formateurDtoUpdated;
	}

	@Override
	public FormateurDto getById(Long id) {
		FormateurDto formateurDtoGot = null;
		try {
			Optional<Formateur> formateurGot = formaterRepo.findById(id);
			if (formateurGot.isPresent()) {
				formateurDtoGot = formateurTransformer.toDto(formateurGot.get());
			}

		} catch (Exception e) {
			log.error("FormateurServiceImpl-> getById error: " + e.getMessage());
		}
		return formateurDtoGot;
	}

	@Override
	public void deleteById(Long id) {
		try {
			formaterRepo.deleteById(id);
		} catch (Exception e) {
			log.error("FormateurServiceImpl-> deleteById error: " + e.getMessage());
		}

	}

	@Override
	public List<FormateurDto> getAll() {
		List<FormateurDto> listFormateurDto = new ArrayList<FormateurDto>();
		try {
			List<Formateur> listFormateur = formaterRepo.findAll();
			listFormateurDto = formateurTransformer.toDtoList(listFormateur);

		} catch (Exception e) {
			log.error("FormateurServiceImpl-> getAll error: " + e.getMessage());
		}

		return listFormateurDto;
	}


}
