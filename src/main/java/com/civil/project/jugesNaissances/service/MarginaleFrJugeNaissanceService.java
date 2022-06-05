package com.civil.project.jugesNaissances.service;


import com.civil.project.jugesNaissances.entity.MargJugeNaissFr;

import java.util.List;

public interface MarginaleFrJugeNaissanceService {

    //////////////////////////////Partie Marginale francais de juge de naissance
    void AjouterOuModifierMargFR(MargJugeNaissFr margJugeNaissFr);
    List<MargJugeNaissFr> afficherMarginalFr();
    void SupprimerMargFR(int idMarginal);
    List<MargJugeNaissFr> MargFrByIdActeJugeNaissance(int idActeJugeNaissa);
    MargJugeNaissFr MargFrById(int id);
}
