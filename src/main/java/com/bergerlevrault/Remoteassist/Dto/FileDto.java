package com.bergerlevrault.Remoteassist.Dto;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FileDto {

    private Long id;

    private ChatDto chat;

    @Lob
    private byte[] File;


}
