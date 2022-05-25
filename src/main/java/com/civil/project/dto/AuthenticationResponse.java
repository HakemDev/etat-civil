package com.civil.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthenticationResponse  {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }


}
