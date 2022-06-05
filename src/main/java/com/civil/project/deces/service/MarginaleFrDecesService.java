package com.civil.project.deces.service;

import com.civil.project.deces.entity.MarginaleDecesFr;

public interface MarginaleFrDecesService {

    void ajouterMargFrD(MarginaleDecesFr marginaleDecesFr);
    void modifierMargFrD(MarginaleDecesFr marginaleDecesFr);
    MarginaleDecesFr trouverParId(int i);
    void supprimer(int i);

}
