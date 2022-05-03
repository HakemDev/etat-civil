package com.civil.project.service;

import com.civil.project.entity.RegistreJugeNaiss;

import java.util.List;

public interface RegistreJugeNaissance {
    //////////////////////////////Partie Registre de juge de naissance
    List<RegistreJugeNaiss> findRegistres();
    List<RegistreJugeNaiss> findByDate(int date);
    RegistreJugeNaiss findByIdRegistre(int idActe);
    void deleteActe(int id);
    void addOrUpdateRegistre(RegistreJugeNaiss registre);
}
