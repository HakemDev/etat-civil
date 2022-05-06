package com.civil.project.service;

import com.civil.project.dto.Reception;

import java.util.List;

public interface ReceptionService {

    Reception PourcentagActeGlobal();
    Reception NombregActePourcentageGlobal();
    List<Reception> NombreActeAnnee();

}
