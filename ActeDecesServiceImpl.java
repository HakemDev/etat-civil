package com.civil.project.service;

import com.civil.project.dao.DecesActeRep;
import com.civil.project.entity.ActeDeces;
import com.civil.project.entity.RegistreJugeNaiss;
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
