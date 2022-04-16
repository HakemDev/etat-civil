package com.civil.project.dao;

import com.civil.project.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRep_user3 extends JpaRepository<Utilisateur,Integer> {
    List<Utilisateur> findByRole(String role);
}
