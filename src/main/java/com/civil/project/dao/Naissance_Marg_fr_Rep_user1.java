package com.civil.project.dao;

import com.civil.project.entity.MargNaisFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Naissance_Marg_fr_Rep_user1 extends JpaRepository<MargNaisFr, Integer> {
    List<MargNaisFr> findByIdActeNais(int id);
}
