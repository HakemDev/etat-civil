package com.civil.project.service;

import com.civil.project.entity.MarginaleDecesAr;
import com.civil.project.entity.MarginaleDecesFr;

public interface MarginaleFrDecesService {

    void ajouterMargFrD(MarginaleDecesFr marginaleDecesFr);
    void modifierMargFrD(MarginaleDecesFr marginaleDecesFr);
    MarginaleDecesFr trouverParId(int i);
    void supprimer(int i);

}
