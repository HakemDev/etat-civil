package com.civil.project.service;

import com.civil.project.entity.RegistreDeces;

import java.util.List;

public interface RegistreDecesService {
    void ajouterRegistreD(RegistreDeces registreDeces);
    void modifierRegistreD(RegistreDeces registreDeces);
    RegistreDeces trouverParId(int i);
    List<RegistreDeces> listerRegistreD();
    void supprimerRegistreD(int i);


}
