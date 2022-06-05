package com.civil.project.naissances.dao;

import com.civil.project.naissances.entity.MargNaisAr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MargNaissArRepository extends JpaRepository<MargNaisAr, Integer> {

    List<MargNaisAr> findByActeNaissanceIdNaissance(int id);
}
