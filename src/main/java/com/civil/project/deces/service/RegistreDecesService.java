package com.civil.project.deces.service;

import com.civil.project.deces.entity.RegistreDeces;

import java.util.List;

public interface RegistreDecesService {
    RegistreDeces ajouterRegistreD(RegistreDeces registreDeces);
    RegistreDeces modifierRegistreD(RegistreDeces registreDeces);
    RegistreDeces trouverParId(int i);
    List<RegistreDeces> listerRegistreD();
    RegistreDeces findRegistreDecesByAnneeAndPartie(int annee,int partie);
    void supprimerRegistreD(int i);


}
