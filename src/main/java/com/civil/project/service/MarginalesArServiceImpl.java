package com.civil.project.service;

import com.civil.project.dao.MargNaissArRepository;
import com.civil.project.dao.NaissanceActeRepository;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.MargNaisAr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginalesArServiceImpl implements MarginalesArService {

    private final MargNaissArRepository repository;
    private final NaissanceActeRepository naissanceActeRepository;

    @Override
    public MargNaisAr addMarg(MargNaisAr margNaisAr) {

        Optional<ActeNaissance> acteNaissance = naissanceActeRepository.findById(
                margNaisAr.getActeNaissance().getIdNaissance()
        );
        if( !acteNaissance.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte introuvable");
        }
        margNaisAr.setActeNaissance(acteNaissance.get());

        return repository.save(margNaisAr);
    }

    @Override
    public List<MargNaisAr> findMargNaisArByIdActe(Integer idActe) {
        List<MargNaisAr> margNais = repository.findByActeNaissanceIdNaissance(idActe);
        if(margNais == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte non trouve");

        return margNais;
    }

    @Override
    public MargNaisAr updateMarg(MargNaisAr margNaisAr) {

        Optional<MargNaisAr> byId = repository.findById(margNaisAr.getIdMarginalAr());
        if(!byId.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Marginale non trouvee");

        if(margNaisAr.getMarginaleTxtAr().trim().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Le texte ne peut pas etre vide");
        }
        MargNaisAr toUpdate = byId.get();
        toUpdate.setMarginaleTxtAr(margNaisAr.getMarginaleTxtAr());
        return repository.save(toUpdate);
    }

    @Override
    public List<MargNaisAr> findAllMargNaisAr() {
        return repository.findAll();
    }

    @Override
    public void deleteMarg(int id) {
        repository.deleteById(id);
    }

    @Override
    public MargNaisAr findMargNaisById(Integer id) {
        return null;
    }
}
