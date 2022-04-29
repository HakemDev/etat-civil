package com.civil.project.service;

import com.civil.project.dao.NaissanceActeRep_user2;
import com.civil.project.dao.NaissanceRegistreRep_user3;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class User2_ActeServiceImpl implements User2_ActeService {

    private final NaissanceActeRep_user2 repo;

    private final NaissanceRegistreRep_user3 registreRepo;

    @Override
    public ActeNaissance addActe(ActeNaissance acteNaissance) {
        RegistreNaiss registre = registreRepo.findRegistreNaissByAnneeAndPartie(
                acteNaissance.getRegistre().getAnnee(),
                acteNaissance.getRegistre().getPartie()
        );
        acteNaissance.setRegistre(registre);
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
