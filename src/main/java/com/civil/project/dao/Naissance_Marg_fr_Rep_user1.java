package com.civil.project.dao;

import com.civil.project.entity.Marg_nais_fr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Naissance_Marg_fr_Rep_user1 extends JpaRepository<Marg_nais_fr, Integer> {
    List<Marg_nais_fr> findByIdActeNais(int id);
}
