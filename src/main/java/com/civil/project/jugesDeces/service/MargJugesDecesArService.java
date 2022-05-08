package com.civil.project.jugesDeces.service;

import com.civil.project.jugesDeces.entity.MarginaleJugeDecesAr;

import java.util.List;

public interface MargJugesDecesArService {
    List<MarginaleJugeDecesAr> findMarginalesByIdJuges(Integer id);

    MarginaleJugeDecesAr addMarg(MarginaleJugeDecesAr marg);

    List<MarginaleJugeDecesAr> findAllMargJugesDecesAr();

    MarginaleJugeDecesAr updateMarg(MarginaleJugeDecesAr marg);

    void deleteMarg(int id);
}
