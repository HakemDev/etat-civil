package com.civil.project.service;

import com.civil.project.entity.ActeNaissance;


import java.util.Collection;


public interface User2_ActeService {

    ActeNaissance addActe(ActeNaissance acteNaissance);

    ActeNaissance updateActe(ActeNaissance acteNaissance);

    void deleteActe(Integer idActe);

    Collection<ActeNaissance> findActes(String nomAr, String nomFr, String numero);

}

