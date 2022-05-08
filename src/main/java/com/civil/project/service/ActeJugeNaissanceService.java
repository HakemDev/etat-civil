package com.civil.project.service;


import com.civil.project.entity.ActeJugeNaissancee;
import com.civil.project.entity.ActeNaissance;

import java.util.Collection;
import java.util.List;

public interface ActeJugeNaissanceService {

    ActeJugeNaissancee AjouterOuModifierActeJugNaissa(ActeJugeNaissancee acteJugeNaissance);

    List<ActeJugeNaissancee> afficherActeJugeNaiss();

    void SupprimerActeJugeNaiss(int idActeJugeNais);

    ActeJugeNaissancee ActeJugeNaiss(int id);

    List<ActeJugeNaissancee> findActesJugeNaissance(String nomAr, String nomFr, String numero);

    ActeJugeNaissancee ModifierActeJugNaissa(ActeJugeNaissancee acteJugeNaissancee);
}
