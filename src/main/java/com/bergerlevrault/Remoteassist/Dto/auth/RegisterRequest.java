package com.bergerlevrault.Remoteassist.Dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public record RegisterRequest (
        String name,
        String prenom,
        String email,
        String password
){
}