package com.civil.project.jugesDeces.service;

import com.civil.project.jugesDeces.dao.JugeDecesRepository;
import com.civil.project.jugesDeces.dao.MargJugeDecesFrRepository;
import com.civil.project.jugesDeces.entity.JugeDeces;
import com.civil.project.jugesDeces.entity.MarginaleJugeDecesFr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MargJugesDecesFrServiceImpl implements MargJugesDecesFrService {
    
    private final MargJugeDecesFrRepository repo;
    private final JugeDecesRepository jugeDecesRepository;
    
    
    @Override
    public List<MarginaleJugeDecesFr> findMarginalesByIdJuges(Integer id) {
        List<MarginaleJugeDecesFr> margNais = 
                repo.findMarginaleJugeDecesFrByJugeDecesIddeces(id);
        if(margNais == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Juge non trouve");

        return margNais;
    }

    @Override
    public MarginaleJugeDecesFr addMarg(MarginaleJugeDecesFr marg) {
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
    public List<MarginaleJugeDecesFr> findAllMargJugesDecesFr() {
        return repo.findAll();
    }

    @Override
    public MarginaleJugeDecesFr updateMarg(MarginaleJugeDecesFr marg) {
        Optional<MarginaleJugeDecesFr> byId = repo.findById(marg.getIdMarginale());
        if(!byId.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Marginale non trouvee");

        if(marg.getTexte().trim().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Le texte ne peut pas etre vide");
        }
        MarginaleJugeDecesFr toUpdate = byId.get();
        toUpdate.setTexte(marg.getTexte());
        return repo.save(toUpdate);
    }

    @Override
    public void deleteMarg(int id) {
        repo.deleteById(id);
    }
}
