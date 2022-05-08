package com.civil.project.jugesDeces.dao;

import com.civil.project.jugesDeces.entity.MarginaleJugeDecesAr;
import com.civil.project.jugesDeces.entity.MarginaleJugeDecesFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MargJugeDecesArRepository extends JpaRepository<MarginaleJugeDecesAr,Integer> {

    List<MarginaleJugeDecesAr> findMarginaleJugeDecesArByJugeDecesIddeces(int id);

}
