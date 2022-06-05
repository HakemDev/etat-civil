package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesMargFrRep;
import com.civil.project.deces.entity.MarginaleDecesFr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional

public class MarginaleFrDecesServiceImpl implements MarginaleFrDecesService{
    @Autowired
    DecesMargFrRep rep;


    @Override
    public void ajouterMargFrD(MarginaleDecesFr marginaleDecesFr) {
        rep.save(marginaleDecesFr);

    }

    @Override
    public void modifierMargFrD(MarginaleDecesFr marginaleDecesFr) {
        rep.save(marginaleDecesFr);

    }

    @Override
    public MarginaleDecesFr trouverParId(int i) {
        Optional<MarginaleDecesFr> result=rep.findById(i);
        return result.get();
    }

    @Override
    public void supprimer(int i) {
        rep.deleteById(i);

    }
}
