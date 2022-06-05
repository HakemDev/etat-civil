package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.entity.MargJugeNaissAr;

import java.util.List;

public interface MarginaleArJugeNaissanceService {

/////////////////////////////Partie Marginale Arabe de juge de naissance

    MargJugeNaissAr AjouterOuModifierMargAr(MargJugeNaissAr margJugeNaissAr);
    List<MargJugeNaissAr> afficherMarginalAr();
    void SupprimerMargAr(int idMargeJuge);
    List<MargJugeNaissAr> MargArByIdActeJugeNaissance(int id);
    MargJugeNaissAr MargArById(int id);
}
