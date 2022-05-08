package com.civil.project.jugesDeces.service;

import com.civil.project.jugesDeces.dao.JugeDecesRepository;
import com.civil.project.jugesDeces.dao.RegistreJugeDecesRepository;
import com.civil.project.jugesDeces.entity.JugeDeces;
import com.civil.project.jugesDeces.entity.RegistreJugesDeces;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.*;

@Service
@RequiredArgsConstructor
public class JugesDecesServiceImpl implements JugesDecesService{


    private final JugeDecesRepository repo;

    private final RegistreJugeDecesRepository registreRepo;

    @Override
    public JugeDeces addJuge(JugeDeces jugeDeces) {
        RegistreJugesDeces registreJuge = registreRepo.findRegistreJugesDecesByAnneeAndPartie(
                jugeDeces.getRegistreJugesDeces().getAnnee(),
                jugeDeces.getRegistreJugesDeces().getPartie()
        );

        if(registreJuge == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'exsite pas",
                            jugeDeces.getRegistreJugesDeces().getAnnee(),
                            jugeDeces.getRegistreJugesDeces().getPartie()));
        }

        for(JugeDeces juge : registreJuge.getJugeDeces()) {
            if(jugeDeces.getNumJugeDeces() == juge.getNumJugeDeces()
            && jugeDeces.getIddeces() != juge.getIddeces()
            )
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("L'acte numero %d dans le registre %d/%d existe deja",
                                jugeDeces.getNumJugeDeces(),
                                jugeDeces.getRegistreJugesDeces().getAnnee(),
                                jugeDeces.getRegistreJugesDeces().getPartie()));
        }

        registreJuge.setNombreJuges(registreJuge.getNombreJuges()+1);
        registreJuge.setDernierNumero(jugeDeces.getNumJugeDeces());
        if(jugeDeces.getRegistreJugesDeces().getIdRegistreDeces() == 0)
            jugeDeces.setRegistreJugesDeces(registreJuge);
        return repo.save(jugeDeces);
    }

    @Override
    public JugeDeces updateJuge(JugeDeces jugeDeces) {
        if(jugeDeces ==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Juge invalide");
        }
        if( !repo.findById(jugeDeces.getIddeces()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Juge non existant");
        }

        return addJuge(jugeDeces);
    }

    @Override
    public void deleteJuge(Integer idJuge) {
        repo.deleteById(idJuge);
    }

    @Override
    public Set<JugeDeces> findJuges(String nomAr, String nomFr, String numero) {

        Set<JugeDeces> byNomAr = null, byNomFr = null;
        List<JugeDeces> byNumero = null;

        if(nomAr != null) {
            byNomAr = repo.findJugeDecesByNomAr(nomAr);
        }

        if(nomFr != null) {
            byNomFr = repo.findJugeDecesByNomFr(nomFr);
        }

        if(numero != null) {
            String[] partieAnnee = numero.split("/");
            RegistreJugesDeces registreJugesDeces = registreRepo.findRegistreJugesDecesByAnneeAndPartie(
                    Integer.parseInt(partieAnnee[1]),
                    Integer.parseInt(partieAnnee[0])
            );
            byNumero = registreJugesDeces != null ?
                    registreJugesDeces.getJugeDeces() : new ArrayList<>();
        }

        Set<JugeDeces> result = new HashSet<>(repo.findAll());

        if(byNomAr != null) result.retainAll(byNomAr);
        if(byNomFr != null) result.retainAll(byNomFr);
        if(byNumero != null) result.retainAll(byNumero);

        return result;
    }

    @Override
    public JugeDeces findJugeById(Integer id) {
        Optional<JugeDeces> juge = repo.findById(id);
        if(!juge.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Juge non trouve");

        return juge.get();
    }
}
