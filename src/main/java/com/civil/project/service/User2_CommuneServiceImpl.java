package com.civil.project.service;

import com.civil.project.dao.CommuneRep_user2;
import com.civil.project.entity.Commune;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class User2_CommuneServiceImpl implements User2_CommuneService {

    private final CommuneRep_user2 communeRepo;

    @Override
    public Commune addCommune(Commune commune) {
        return communeRepo.save(commune);
    }

    @Override
    public Commune updateCommune(Commune commune) {
        return communeRepo.save(commune);
    }

    @Override
    public void deleteCommune(Integer idCommune) {
        communeRepo.deleteById(idCommune);
    }
}
