package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesRegistreRep;
import com.civil.project.deces.entity.RegistreDeces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegistreDecesServiceImlp implements RegistreDecesService {

    @Autowired
    DecesRegistreRep rep;

    @Override
    public void ajouterRegistreD(RegistreDeces registreDeces) {
        rep.save(registreDeces);

    }

    @Override
    public void modifierRegistreD(RegistreDeces registreDeces) {
        rep.save(registreDeces);

    }

    @Override
    public RegistreDeces trouverParId(int i) {
        Optional<RegistreDeces> result=rep.findById(i);
        return result.get() ;
    }

    @Override
    public List<RegistreDeces> listerRegistreD() {
        return rep.findAll();
    }

    @Override
    public void supprimerRegistreD(int i) {
        rep.deleteById(i);

    }
}
