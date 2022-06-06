package com.civil.project.deces.dao;

import com.civil.project.deces.entity.MarginaleDecesFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarginaleDecesFrRepository extends JpaRepository<MarginaleDecesFr,Integer> {

    List<MarginaleDecesFr> findMarginaleDecesFrByActeDecesIdDeces(int id);
}
