package com.civil.project.service;

import com.civil.project.entity.ActeNaissance;

public interface User2_ActeService {

    ActeNaissance addActe(ActeNaissance acteNaissance);

    ActeNaissance updateActe(ActeNaissance acteNaissance);

    void deleteActe(Integer idActe);
}
