package com.civil.project.deces.service;

import com.civil.project.deces.dao.DecesActeRep;
import com.civil.project.deces.dao.MarginaleDecesArRepository;
import com.civil.project.deces.entity.ActeDeces;
import com.civil.project.deces.entity.MarginaleDecesAr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginaleDecesArService {

    private final MarginaleDecesArRepository repo;
    private final DecesActeRep decesActeRepo;

    public List<MarginaleDecesAr> findMarginaleByIdActe(Integer id){
        List<MarginaleDecesAr> marginales = repo.findMarginaleDecesArByActeDecesIdDeces(id);

        if(marginales == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");

        return marginales;
    }

    public MarginaleDecesAr addMarg(MarginaleDecesAr marg) {
        Optional<ActeDeces> acte = decesActeRepo.findById(marg.getActeDeces().getIdDeces());

        if(!acte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");
        }
        marg.setActeDeces(acte.get());

        return repo.save(marg);
    }

    public List<MarginaleDecesAr> findAll() {return repo.findAll();}

    public MarginaleDecesAr updateMarg(MarginaleDecesAr marg) {
        Optional<MarginaleDecesAr> byId = repo.findById(marg.getIdMarginale());

        if( !byId.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Marginale non trouvee");

        if(marg.getTexte().trim().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Le texte ne peut pas etre vide");
        }

        MarginaleDecesAr toUpdate = byId.get();
        toUpdate.setTexte(marg.getTexte());
        return repo.save(toUpdate);

    }

    public void deleteMarg(int id) {
        repo.deleteById(id);
    }
}
