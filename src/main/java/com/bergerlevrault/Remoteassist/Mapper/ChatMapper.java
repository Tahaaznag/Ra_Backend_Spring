package com.bergerlevrault.Remoteassist.Mapper;

import com.bergerlevrault.Remoteassist.Dto.ChatDto;
import com.bergerlevrault.Remoteassist.Entity.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    @Mapping(target = "session", ignore = true)
    Chat toEntity(ChatDto chatDto);

    @Mapping(target = "session", ignore = true)
    ChatDto toDto(Chat chat);


}
