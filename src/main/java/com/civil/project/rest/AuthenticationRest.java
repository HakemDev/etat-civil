package com.civil.project.rest;

import com.civil.project.dao.UtilisateurRepository;
import com.civil.project.dto.AuthenticationRequest;
import com.civil.project.dto.AuthenticationResponse;
import com.civil.project.service.MyUserDetailsService;
import com.civil.project.service.UtilisateurService;
import com.civil.project.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationRest {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailService;
    private final UtilisateurService utilisateurService;
    private final JwtUtil jwtTokenUtil;


    @PostMapping("/login")
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws ResponseStatusException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Incorrect credentials !");
        }
        final UserDetails userDetails = userDetailService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
