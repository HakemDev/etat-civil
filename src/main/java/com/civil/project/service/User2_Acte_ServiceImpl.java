package com.civil.project.service;

import com.civil.project.dao.NaissanceActeRep_user2;
import com.civil.project.entity.ActeNaissance;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class User2_ActeServiceImpl implements User2_ActeService {

    private final NaissanceActeRep_user2 repo;

    @Override
    public ActeNaissance addActe(ActeNaissance acteNaissance) {
        return repo.save(acteNaissance);
    }

    @Override
    public ActeNaissance updateActe(ActeNaissance acteNaissance) {
        return repo.save(acteNaissance);
    }

    @Override
    public void deleteActe(Integer idActe) {
        repo.deleteById(idActe);
    }
}