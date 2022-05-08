package com.civil.project.jugesDeces;

import com.civil.project.dao.RegistreJugeDecesRepository;
import com.civil.project.entity.RegistreJugesDeces;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistreJugesDecesServiceImpl implements RegistreJugesDecesService{

    private final RegistreJugeDecesRepository repository;

    @Override
    public List<RegistreJugesDeces> getAllRegistreJugesDeces() {
        return repository.findAll();
    }

    @Override
    public RegistreJugesDeces addRegistreDeces(RegistreJugesDeces registre) {

        RegistreJugesDeces duplicateTest = repository
                .findRegistreJugesDecesByAnneeAndPartie(
                        registre.getAnnee(),registre.getPartie()
                );

        if(duplicateTest != null) {
            if(registre.getIdRegistreDeces() == 0 ||
            (registre.getIdRegistreDeces() != 0 &&
                    registre.getIdRegistreDeces() != duplicateTest.getIdRegistreDeces()))

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Le registre %d/%d existe deja",registre.getPartie(),registre.getAnnee()));

        }

        if(registre.getPartie() > 1) {
            RegistreJugesDeces dernier =
                    repository.findRegistreJugesDecesByAnneeAndPartie(registre.getAnnee(),registre.getPartie() - 1);

            if(dernier == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Le registre %d/%d ne peut pas etre cree avant le registre %d/%d",
                                registre.getPartie(),registre.getAnnee(),registre.getPartie()-1,registre.getAnnee()));

            }
        }
        return repository.save(registre);
    }

    @Override
    public RegistreJugesDeces getRegistreJugesDecesById(int idRegistre) {
        Optional<RegistreJugesDeces> byId = repository.findById(idRegistre);
        if(byId.isPresent()){
            return byId.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre juge deces non trouve");
    }

    @Override
    public void deleteRegistre(int id) {
        Optional<RegistreJugesDeces> byId = repository.findById(id);
        byId.ifPresent(repository::delete);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre juge deces non trouve");

    }

    @Override
    public RegistreJugesDeces updateRegistreDeces(RegistreJugesDeces registreJugesDeces) {
        Optional<RegistreJugesDeces> byId = repository.findById(
                registreJugesDeces.getIdRegistreDeces()
        );
        if(byId.isPresent()){
            repository.save(registreJugesDeces);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Registre juge deces non trouve");

    }

    @Override
    public List<RegistreJugesDeces> findByAnnee(int annee) {
        return repository.findRegistreJugesDecesByAnnee(annee);
    }

    @Override
    public RegistreJugesDeces findRegistreJugeDecesByAnneeAndPartie(Integer annee, Integer partie) {

        RegistreJugesDeces result = repository.findRegistreJugesDecesByAnneeAndPartie(annee,partie);
        if(result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Le registre %d/%d n'existe pas",partie,annee));
        }
        return result;
    }
}
