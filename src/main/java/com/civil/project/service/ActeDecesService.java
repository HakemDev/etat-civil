package com.civil.project.service;

import com.civil.project.entity.ActeDeces;

import java.util.List;

public interface ActeDecesService {
    void ajouterActeD(ActeDeces acteDeces);
    void modifierActeD(ActeDeces acteDeces);
    ActeDeces trouverActeDParId(int i);
   // List<ActeDeces> trouverActeDParAnnee(int i);
   // List<ActeDeces> trouverActeDParNom(String i);
   // List<ActeDeces> trouverActeDParNumero(String i);
    List<ActeDeces> listerActeD();
    void supprimerActeD(int i);



}