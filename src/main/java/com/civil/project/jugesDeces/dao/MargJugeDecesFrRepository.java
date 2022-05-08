package com.civil.project.jugesDeces.dao;

import com.civil.project.jugesDeces.entity.MarginaleJugeDecesFr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MargJugeDecesFrRepository extends JpaRepository<MarginaleJugeDecesFr,Integer> {

    List<MarginaleJugeDecesFr> findMarginaleJugeDecesFrByJugeDecesIddeces(int id);

}
