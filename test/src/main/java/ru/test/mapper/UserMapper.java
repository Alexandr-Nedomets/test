package ru.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.test.dto.UserDto;
import ru.test.entity.User;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDto dto);
    List<User> toEntities(Collection<UserDto> dtos);
    UserDto toDto(User entity);
    List<UserDto> toDtos(Collection<User> entities);
}
