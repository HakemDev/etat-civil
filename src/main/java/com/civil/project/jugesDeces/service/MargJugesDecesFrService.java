package com.civil.project.jugesDeces.service;

import com.civil.project.jugesDeces.entity.MarginaleJugeDecesFr;

import java.util.List;

public interface MargJugesDecesFrService {
    List<MarginaleJugeDecesFr> findMarginalesByIdJuges(Integer id);

    MarginaleJugeDecesFr addMarg(MarginaleJugeDecesFr marg);
    
    List<MarginaleJugeDecesFr> findAllMargJugesDecesFr();

    MarginaleJugeDecesFr updateMarg(MarginaleJugeDecesFr marg);

    void deleteMarg(int id);
}
