package com.civil.project.jugesDeces.service;

import com.civil.project.jugesDeces.entity.RegistreJugesDeces;

import java.util.List;

public interface RegistreJugesDecesService {

    List<RegistreJugesDeces> getAllRegistreJugesDeces();

    RegistreJugesDeces getRegistreJugesDecesById(int idRegistre);

    void deleteRegistre(int id);

    RegistreJugesDeces updateRegistreDeces(RegistreJugesDeces registreJugesDeces);

    RegistreJugesDeces addRegistreDeces(RegistreJugesDeces registreJugesDeces);

    List<RegistreJugesDeces> findByAnnee(int annee);

    RegistreJugesDeces findRegistreJugeDecesByAnneeAndPartie(Integer annee,Integer partie);
}
