package com.management.openManagement.mapper;

import com.management.openManagement.dto.UserDto;
import com.management.openManagement.models.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @InheritInverseConfiguration
  UserDto toUserDto(User user);

  @InheritInverseConfiguration
  List<UserDto> toUserDTOs(List<User> users);

  User toUser(UserDto userDto);

}
