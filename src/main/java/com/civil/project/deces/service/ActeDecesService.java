package com.civil.project.deces.service;

import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.deces.entity.RegistreDeces;

import java.util.Set;

public interface ActeDecesService {
    ActeDeces ajouterActeD(ActeDeces acteDeces);
    ActeDeces modifierActeD(ActeDeces acteDeces);
    ActeDeces trouverActeDParId(int i);
    Set<ActeDeces> listerActeD(String nomAr, String nomFr, String numero);
    void supprimerActeD(int i);



}
