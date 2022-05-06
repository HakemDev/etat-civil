package com.civil.project.dao;

import com.civil.project.entity.MargNaisAr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MargNaissArRepository extends JpaRepository<MargNaisAr, Integer> {

    List<MargNaisAr> findByActeNaissanceIdNaissance(int id);
}
