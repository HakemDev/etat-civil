package com.civil.project.service;

import com.civil.project.dto.Reception;

import java.util.List;

public interface ReceptionService {

    Reception PourcentagActeGlobal();
    Reception NombregActeGlobal();
    List<Reception> NombreActeAnnee();

}
