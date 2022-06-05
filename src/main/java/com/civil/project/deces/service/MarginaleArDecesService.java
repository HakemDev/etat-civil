package com.civil.project.deces.service;

import com.civil.project.deces.entity.MarginaleDecesAr;

public interface MarginaleArDecesService {

    void ajouterMargArD(MarginaleDecesAr marginaleDecesAr);
    void modifierMargArD(MarginaleDecesAr marginaleDecesAr);
    MarginaleDecesAr trouverParId(int i);
    void supprimer(int i);
}
