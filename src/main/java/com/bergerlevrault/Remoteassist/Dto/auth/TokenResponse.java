package com.bergerlevrault.Remoteassist.Dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
public class TokenResponse {
    private String token;
}
