package com.civil.project.security.service;

import com.civil.project.security.dao.UtilisateurRepository;
import com.civil.project.security.entity.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@EnableWebSecurity
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur = appUserRepository.findByLogin(s);
        if(utilisateur.isPresent()) {
            Collection<SimpleGrantedAuthority> authorities =
                    Collections.singletonList(new SimpleGrantedAuthority(
                            "ROLE_"+utilisateur.get().getRole()));
            return new User(
                utilisateur.get().getLogin(), utilisateur.get().getMotDePasse(),authorities);
        }
        else {
            throw new UsernameNotFoundException("Login introuvable");
        }
    }
}
