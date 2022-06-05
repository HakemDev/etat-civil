package com.civil.project.jugesNaissances.service;

import com.civil.project.jugesNaissances.entity.RegistreJugeNaiss;

import java.util.List;

public interface RegistreJugeNaissanceService {
    //////////////////////////////Partie Registre de juge de naissance
    List<RegistreJugeNaiss> findRegistres();
    List<RegistreJugeNaiss> findByDate(int date);
    RegistreJugeNaiss findByIdRegistre(int idActe);
    void deleteActe(int id);
    void addOrUpdateRegistre(RegistreJugeNaiss registre);
}
