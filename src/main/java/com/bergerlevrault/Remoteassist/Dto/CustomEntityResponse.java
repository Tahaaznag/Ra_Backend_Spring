package com.bergerlevrault.Remoteassist.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomEntityResponse <T>{
    private Boolean isError;
    private String message;
    private HttpStatus status;
    private T data;

    public CustomEntityResponse(T data) {
        this.data = data;
    }

}
