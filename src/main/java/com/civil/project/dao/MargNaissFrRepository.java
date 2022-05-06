package com.civil.project.dao;

import com.civil.project.entity.MargNaisFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MargNaissFrRepository extends JpaRepository<MargNaisFr, Integer> {
    List<MargNaisFr> findByActeNaissanceIdNaissance(int id);
}
