package com.bergerlevrault.Remoteassist.Mapper;

import com.bergerlevrault.Remoteassist.Dto.UserRaDto;
import com.bergerlevrault.Remoteassist.Entity.UserRa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserRa mapToUser(UserRaDto userDto);

    UserRaDto mapToDto(UserRa user);

    List<UserRaDto> mapToDtoList(List<UserRa> users);

    void updateUserFromDto(UserRaDto userDto, @MappingTarget UserRa user);
}
