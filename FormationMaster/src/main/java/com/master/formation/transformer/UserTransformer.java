package com.master.formation.transformer;

import org.dozer.DozerBeanMapper;

import com.master.formation.dto.UserDto;
import com.master.formation.entity.User;

public class UserTransformer extends GenericTransformer<UserDto, User> {

	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public User toEntity(UserDto dto) {
		User user = mapper.map(dto, User.class);
		return user;
	}

	@Override
	public UserDto toDto(User entity) {
		UserDto userDto = mapper.map(entity, UserDto.class);
		return userDto;
	}

}
