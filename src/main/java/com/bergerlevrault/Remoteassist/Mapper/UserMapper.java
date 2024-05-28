package com.bergerlevrault.Remoteassist.Mapper;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "isAdmin", target = "admin")
    UserRa mapToUser(UserRaDto userDto);

    @Mapping(source = "admin", target = "isAdmin")
    UserRaDto mapToDto(UserRa user);
    List<UserRaDto> mapToDtoList(List<UserRa> users);
    void updateUserFromDto(UserRaDto userDto, @MappingTarget UserRa user);
}
