package com.master.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.master.formation.dto.UserDto;
import com.master.formation.service.UserService;

public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserDto> getAll() {
		return userService.getAll();
	}

	@PostMapping("/createUser")
	public UserDto createUser(@RequestBody UserDto userDto) {
		return userService.create(userDto);
	}

	@PostMapping("/updateUser")
	public UserDto updateUser(@RequestBody UserDto userDto) {
		return userService.update(userDto);
	}

	@GetMapping("getuser/{id}")
	public UserDto get(@PathVariable(value = "id") long id) {
		return userService.getById(id);
	}

	@GetMapping("deleteuser/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		userService.deleteById(id);
	}

}
