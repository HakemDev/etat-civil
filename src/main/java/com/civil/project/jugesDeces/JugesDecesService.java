package com.civil.project.jugesDeces;

import com.civil.project.entity.JugeDeces;

import java.util.List;
import java.util.Set;

public interface JugesDecesService {

    JugeDeces addJuge(JugeDeces jugeDeces);

    JugeDeces updateJuge(JugeDeces jugeDeces);

    void deleteJuge(Integer idJuge);

    Set<JugeDeces> findJuges(String nomAr, String nomFr, String numero);

    JugeDeces findJugeById(Integer id);

}