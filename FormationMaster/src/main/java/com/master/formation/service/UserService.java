package com.master.formation.service;

import java.util.List;

import com.master.formation.dto.UserDto;

public interface UserService {

	UserDto create(UserDto userDTO);

	UserDto update(UserDto userDTO);

	UserDto getById(Long id);

	UserDto getByUsername(String username);

	boolean isExist(String username);

	void deleteById(Long id);

	List<UserDto> getAll();
}
