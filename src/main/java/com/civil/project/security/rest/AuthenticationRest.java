package com.civil.project.security.rest;

import com.civil.project.dto.AuthenticationRequest;
import com.civil.project.dto.AuthenticationResponse;
import com.civil.project.security.entity.Utilisateur;
import com.civil.project.security.service.MyUserDetailsService;
import com.civil.project.security.service.UtilisateurService;
import com.civil.project.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationRest {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailService;
    private final UtilisateurService utilisateurService;
    private final JwtUtil jwtTokenUtil;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws ResponseStatusException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Mot de passe ou nom d'utilisateur incorrects.");
        }
        final UserDetails userDetails = userDetailService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt  = jwtTokenUtil.generateToken(userDetails);

        Utilisateur user = utilisateurService
                .findByLogin(authenticationRequest.getUsername());
        return ResponseEntity.ok(AuthenticationResponse.builder()
                        .accessToken(jwt)
                        .prenomAr(user.getPrenomAr())
                        .nomAr(user.getNomAr())
                        .prenomFr(user.getPrenomFr())
                        .nomFr(user.getNomFr())
                        .role(user.getRole())
                        .login(user.getLogin())
                        .build());
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyToken() {
        return ResponseEntity.ok().build();
    }
}
