package com.civil.project.dao;

import com.civil.project.entity.Marg_nais_ar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Naissance_Marg_ar_Rep_user1 extends JpaRepository<Marg_nais_ar, Integer> {
    //  List<Marg_nais_ar> findById_acte_nais(int id);

    List<Marg_nais_ar> findByIdActeNais(int id);
}
