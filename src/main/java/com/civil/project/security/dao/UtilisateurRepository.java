package com.civil.project.security.dao;

import com.civil.project.security.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    List<Utilisateur> findByRole(String role);

    Optional<Utilisateur> findByLogin(String login);
}
