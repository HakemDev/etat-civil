package com.civil.project.service;


import com.civil.project.entity.MargJugeNaissFr;

import java.util.List;

public interface MargianleFrJugeNaissanceService {

    //////////////////////////////Partie Marginale francais de juge de naissance
    void AjouterOuModifierMargFR(MargJugeNaissFr margJugeNaissFr);
    List<MargJugeNaissFr> afficherMarginalFr();
    void SupprimerMargFR(int idMarginal);
    List<MargJugeNaissFr> MargFrByIdActeJugeNaissance(int idActeJugeNaissa);
    MargJugeNaissFr MargFrById(int id);
}
