package com.civil.project.service;

import com.civil.project.entity.MarginaleDecesAr;

public interface MarginaleArDecesService {

    void ajouterMargArD(MarginaleDecesAr marginaleDecesAr);
    void modifierMargArD(MarginaleDecesAr marginaleDecesAr);
    MarginaleDecesAr trouverParId(int i);
    void supprimer(int i);
}
