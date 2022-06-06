package com.civil.project.deces.dao;

import com.civil.project.deces.entity.MarginaleDecesAr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarginaleDecesArRepository extends JpaRepository<MarginaleDecesAr,Integer> {

    List<MarginaleDecesAr> findMarginaleDecesArByActeDecesIdDeces(Integer id);



}
