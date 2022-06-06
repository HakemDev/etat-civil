package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.dao.MarginaleDecesFrRepository;
import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.deces.entity.MarginaleDecesFr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginaleDecesFrService {

    private final MarginaleDecesFrRepository repo;
    private final DecesActeRep decesActeRepo;

    public List<MarginaleDecesFr> findMarginaleByIdActe(Integer id){
        List<MarginaleDecesFr> marginales = repo.findMarginaleDecesFrByActeDecesIdDeces(id);

        if(marginales == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");

        return marginales;
    }

    public MarginaleDecesFr addMarg(MarginaleDecesFr marg) {
        Optional<ActeDeces> acte = decesActeRepo.findById(marg.getActeDeces().getIdDeces());

        if(!acte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");
        }
        marg.setActeDeces(acte.get());

        return repo.save(marg);
    }

    public List<MarginaleDecesFr> findAll() {return repo.findAll();}

    public MarginaleDecesFr updateMarg(MarginaleDecesFr marg) {
        Optional<MarginaleDecesFr> byId = repo.findById(marg.getIdMarginale());

        if( !byId.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Marginale non trouvee");

        if(marg.getTexte().trim().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Le texte ne peut pas etre vide");
        }

        MarginaleDecesFr toUpdate = byId.get();
        toUpdate.setTexte(marg.getTexte());
        return repo.save(toUpdate);

    }

    public void deleteMarg(int id) {
        repo.deleteById(id);
    }
}
