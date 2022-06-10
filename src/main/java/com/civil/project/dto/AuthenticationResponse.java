package com.civil.project.dto;

import lombok.*;

@Data
@Builder
public class AuthenticationResponse  {

    private String accessToken;
    private String nomAr;
    private String nomFr;
    private String prenomFr;
    private String prenomAr;
    private String role;
    
}
