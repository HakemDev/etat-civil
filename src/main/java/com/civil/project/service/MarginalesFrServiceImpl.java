package com.civil.project.service;

import com.civil.project.dao.MargNaissFrRepository;
import com.civil.project.dao.NaissanceActeRepository;
import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.MargNaisFr;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarginalesFrServiceImpl implements MarginalesFrService {

    private final MargNaissFrRepository repository;
    private final NaissanceActeRepository naissanceActeRepository;

    @Override
    public MargNaisFr addMarg(MargNaisFr margNaisFr) {

        Optional<ActeNaissance> acteNaissance = naissanceActeRepository.findById(
                margNaisFr.getActeNaissance().getIdNaissance()
        );
        if( !acteNaissance.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Acte introuvable");
        }
        margNaisFr.setActeNaissance(acteNaissance.get());

        return repository.save(margNaisFr);
    }

    @Override
    public List<MargNaisFr> findMargNaisFrByIdActe(Integer idActe) {
        List<MargNaisFr> margNais = repository.findByActeNaissanceIdNaissance(idActe);
        if(margNais == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return margNais;
    }


    @Override
    public List<MargNaisFr> findAllMargNaisFr() {
        return repository.findAll();
    }


    @Override
    public MargNaisFr findMargNaisById(Integer id) {
        return null;
    }
}
