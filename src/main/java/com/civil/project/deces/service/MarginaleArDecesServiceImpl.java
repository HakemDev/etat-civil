package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesMargArRep;
import com.civil.project.deces.entity.MarginaleDecesAr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional

public class MarginaleArDecesServiceImpl implements MarginaleArDecesService {
    @Autowired
    DecesMargArRep rep;

    @Override
    public void ajouterMargArD(MarginaleDecesAr marginaleDecesAr) {
        rep.save(marginaleDecesAr);

    }

    @Override
    public void modifierMargArD(MarginaleDecesAr marginaleDecesAr) {
        rep.save(marginaleDecesAr);

    }

    @Override
    public MarginaleDecesAr trouverParId(int i) {

        Optional<MarginaleDecesAr> result=rep.findById(i);

        return result.get();
    }

    @Override
    public void supprimer(int i) {
        rep.deleteById(i);

    }
}
