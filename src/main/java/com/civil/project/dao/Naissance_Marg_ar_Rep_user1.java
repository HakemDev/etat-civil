package com.civil.project.dao;

import com.civil.project.entity.MargNaisAr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Naissance_Marg_ar_Rep_user1 extends JpaRepository<MargNaisAr, Integer> {
    //  List<MargNaisAr> findById_acte_nais(int id);

    List<MargNaisAr> findByIdActeNais(int id);
}
