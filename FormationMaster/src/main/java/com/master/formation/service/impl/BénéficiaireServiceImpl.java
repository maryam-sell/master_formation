package com.master.formation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.formation.dto.BénéficiaireDto;
import com.master.formation.entity.Bénéficiaire;
import com.master.formation.repository.BénéficiaireRepository;
import com.master.formation.service.BénéficiaireService;
import com.master.formation.transformer.BénéficiaireTransformer;
@Service
public class BénéficiaireServiceImpl implements BénéficiaireService {

	private Logger log = Logger.getLogger(FormateurServiceImpl.class);
	@Autowired
	private BénéficiaireRepository bénéficiaireRepo;
	private BénéficiaireTransformer bénéficiaireTransformer = new BénéficiaireTransformer();

	@Override
	public BénéficiaireDto create(BénéficiaireDto bénéficiaireDto) {
		BénéficiaireDto bénéficiaireDtoCreated = null;
		try {
			Bénéficiaire bénéficiaire = bénéficiaireTransformer.toEntity(bénéficiaireDto);
			Bénéficiaire bénéficiaireCreated = bénéficiaireRepo.save(bénéficiaire);
			bénéficiaireDtoCreated = bénéficiaireTransformer.toDto(bénéficiaireCreated);

		} catch (Exception e) {
			log.error("BénéficiaireServiceImpl-> create error: " + e.getMessage());
		}
		return bénéficiaireDtoCreated;
	}

	@Override
	public BénéficiaireDto update(BénéficiaireDto bénéficiaireDto) {
		BénéficiaireDto bénéficiaireDtoUpdated = null;
		try {
			BénéficiaireDto bénéficiaireDtoToUpdate = getById(bénéficiaireDto.getId());
			if (bénéficiaireDtoToUpdate != null) {
				bénéficiaireDtoToUpdate.setAdress(bénéficiaireDto.getAdress());
				bénéficiaireDtoToUpdate.setEmail(bénéficiaireDto.getEmail());
				bénéficiaireDtoToUpdate.setPassword(bénéficiaireDto.getPassword());
				bénéficiaireDtoToUpdate.setPhone(bénéficiaireDto.getPhone());
				bénéficiaireDtoToUpdate.setRoles(bénéficiaireDto.getRoles());
				bénéficiaireDtoToUpdate.setUsername(bénéficiaireDto.getUsername());
				Bénéficiaire bénéficiaire = bénéficiaireTransformer.toEntity(bénéficiaireDtoToUpdate);
				Bénéficiaire bénéficiaireUpdated = bénéficiaireRepo.save(bénéficiaire);
				bénéficiaireDtoUpdated = bénéficiaireTransformer.toDto(bénéficiaireUpdated);
			}

		} catch (Exception e) {
			log.error("BénéficiaireServiceImpl-> update error: " + e.getMessage());
		}
		return bénéficiaireDtoUpdated;
	}

	@Override
	public BénéficiaireDto getById(Long id) {
		BénéficiaireDto bénéficiaireDtoGot = null;
		try {
			Optional<Bénéficiaire> bénéficiaireGot = bénéficiaireRepo.findById(id);
			if (bénéficiaireGot.isPresent()) {
				bénéficiaireDtoGot = bénéficiaireTransformer.toDto(bénéficiaireGot.get());
			}

		} catch (Exception e) {
			log.error("BénéficiaireServiceImpl-> getById error: " + e.getMessage());
		}
		return bénéficiaireDtoGot;
	}

	@Override
	public void deleteById(Long id) {
		try {
			bénéficiaireRepo.deleteById(id);
		} catch (Exception e) {
			log.error("BénéficiaireServiceImpl-> deleteById error: " + e.getMessage());
		}

	}

	@Override
	public List<BénéficiaireDto> getAll() {
		List<BénéficiaireDto> listBénéficiaireDto = new ArrayList<BénéficiaireDto>();
		try {
			List<Bénéficiaire> listBénéficiaire = bénéficiaireRepo.findAll();
			listBénéficiaireDto = bénéficiaireTransformer.toDtoList(listBénéficiaire);

		} catch (Exception e) {
			log.error("BénéficiaireServiceImpl-> getAll error: " + e.getMessage());
		}

		return listBénéficiaireDto;
	}

}
