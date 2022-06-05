package com.civil.project.jugesDeces.service;

import com.civil.project.jugesDeces.dao.JugeDecesRepository;
import com.civil.project.jugesDeces.dao.MargJugeDecesArRepository;
import com.civil.project.jugesDeces.entity.JugeDeces;
import com.civil.project.jugesDeces.entity.MarginaleJugeDecesAr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MargJugesDecesArServiceImpl implements MargJugesDecesArService {
    
    private final MargJugeDecesArRepository repo;
    private final JugeDecesRepository jugeDecesRepository;
    
    
    @Override
    public List<MarginaleJugeDecesAr> findMarginalesByIdJuges(Integer id) {
        List<MarginaleJugeDecesAr> margNais = 
                repo.findMarginaleJugeDecesArByJugeDecesIddeces(id);
        if(margNais == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Juge non trouve");

        return margNais;
    }

    @Override
    public MarginaleJugeDecesAr addMarg(MarginaleJugeDecesAr marg) {
        Optional<JugeDeces> jugeDeces = jugeDecesRepository.findById(
                marg.getJugeDeces().getIddeces()
        );
        if( !jugeDeces.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Juge introuvable");
        }
        marg.setJugeDeces(jugeDeces.get());

        return repo.save(marg);
    }

    @Override
    public List<MarginaleJugeDecesAr> findAllMargJugesDecesAr() {
        return repo.findAll();
    }

    @Override
    public MarginaleJugeDecesAr updateMarg(MarginaleJugeDecesAr marg) {
        Optional<MarginaleJugeDecesAr> byId = repo.findById(marg.getIdMarginale());
        if(!byId.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Marginale non trouvee");

        if(marg.getTexte().trim().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Le texte ne peut pas etre vide");
        }
        MarginaleJugeDecesAr toUpdate = byId.get();
        toUpdate.setTexte(marg.getTexte());
        return repo.save(toUpdate);
    }

    @Override
    public void deleteMarg(int id) {
        repo.deleteById(id);
    }
}
