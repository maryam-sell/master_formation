package com.master.formation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.master.formation.dto.UserDto;
import com.master.formation.entity.User;
import com.master.formation.repository.UserRepository;
import com.master.formation.service.UserService;
import com.master.formation.transformer.UserTransformer;

public class UserServiceImpl implements UserService {

	private Logger log = Logger.getLogger(FormateurServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	private UserTransformer userTransformer = new UserTransformer();

	@Override
	public UserDto create(UserDto userDTO) {
		UserDto userDtoCreated = null;
		try {
			User user = userTransformer.toEntity(userDTO);
			User userCreaeted = userRepository.save(user);
			userDtoCreated = userTransformer.toDto(userCreaeted);

		} catch (Exception e) {
			log.error("UserServiceImpl-> create error: " + e.getMessage());
		}
		return userDtoCreated;
	}

	@Override
	public UserDto update(UserDto userDTO) {

		UserDto userDtoUpdated = null;
		try {
			UserDto userDtoToUpdate = getById(userDTO.getId());
			if (userDtoToUpdate != null) {
				userDtoToUpdate.setAdress(userDTO.getAdress());
				userDtoToUpdate.setEmail(userDTO.getEmail());
				userDtoToUpdate.setPassword(userDTO.getPassword());
				userDtoToUpdate.setPhone(userDTO.getPhone());
				userDtoToUpdate.setRoles(userDTO.getRoles());
				userDtoToUpdate.setUsername(userDTO.getUsername());
				User user = userTransformer.toEntity(userDtoToUpdate);
				User userUpdated = userRepository.save(user);
				userDtoUpdated = userTransformer.toDto(userUpdated);
			}

		} catch (Exception e) {
			log.error("UserServiceImpl-> update error: " + e.getMessage());
		}
		return userDtoUpdated;
	}

	@Override
	public UserDto getById(Long id) {
		UserDto userDtoGot = null;
		try {
			Optional<User> userGot = userRepository.findById(id);
			if (userGot.isPresent()) {
				userDtoGot = userTransformer.toDto(userGot.get());
			}
		} catch (Exception e) {
			log.error("UserServiceImpl-> getById error: " + e.getMessage());
		}
		return userDtoGot;
	}

	@Override
	public UserDto getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			log.error("UserServiceImpl-> deleteById error: " + e.getMessage());
		}

	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> listUserDto = new ArrayList<UserDto>();
		try {
			List<User> listUser = userRepository.findAll();
			listUserDto = userTransformer.toDtoList(listUser);

		} catch (Exception e) {
			log.error("UserServiceImpl-> getAll error: " + e.getMessage());
		}
		return listUserDto;
	}

}
