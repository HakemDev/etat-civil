package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.entity.ActeDeces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActeDecesServiceImpl implements ActeDecesService {


    @Autowired
    DecesActeRep rep;


    @Override
    public void ajouterActeD(ActeDeces acteDeces) {
        rep.save(acteDeces);

    }

    @Override
    public void modifierActeD(ActeDeces acteDeces) {
        rep.save(acteDeces);

    }

    @Override
    public ActeDeces trouverActeDParId(int i) {
        Optional<ActeDeces> result=rep.findById(i);
        // todo check if acte is present else throw exception
        return result.get();
    }


    @Override
    public List<ActeDeces> listerActeD() {
        return rep.findAll();
    }

    @Override
    public void supprimerActeD(int i) { rep.deleteById(i);

    }
}
