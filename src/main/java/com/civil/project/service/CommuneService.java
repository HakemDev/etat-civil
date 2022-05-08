package com.civil.project.service;

import com.civil.project.entity.Commune;

public interface CommuneService {

    Commune addCommune(Commune commune);

    Commune updateCommune(Commune commune);

    void deleteCommune(Integer idCommune);

}
