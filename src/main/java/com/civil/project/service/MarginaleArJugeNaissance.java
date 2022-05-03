package com.civil.project.service;

import com.civil.project.entity.MargJugeNaissAr;
import com.civil.project.entity.MargJugeNaissFr;

import java.util.List;

public interface MarginaleArJugeNaissance {

/////////////////////////////Partie Marginale Arabe de juge de naissance
    void AjouterOuModifierMargAr(MargJugeNaissAr margJugeNaissAr);
    List<MargJugeNaissAr> afficherMarginalAr();
    void SupprimerMargAr(int idMargeJuge);
    List<MargJugeNaissAr> MargArByIdActeJugeNaissance(int id);
    MargJugeNaissAr MargArById(int id);
}
