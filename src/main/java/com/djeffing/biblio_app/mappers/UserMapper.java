package com.djeffing.biblio_app.mappers;

import com.djeffing.biblio_app.Models.User;
import com.djeffing.biblio_app.dtos.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDo(User user);
    User toUser(UserDto userDto);
}
