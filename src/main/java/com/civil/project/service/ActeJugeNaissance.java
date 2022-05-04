package com.civil.project.service;


import com.civil.project.entity.ActeJugeNaissancee;

import java.util.List;

public interface ActeJugeNaissance {

    void AjouterOuModifierActeJugNaissa(ActeJugeNaissancee acteJugeNaissance);

    List<ActeJugeNaissancee> afficherActeJugeNaiss();

    void SupprimerActeJugeNaiss(int idActeJugeNais);

    ActeJugeNaissancee ActeJugeNaiss(int id);
}
