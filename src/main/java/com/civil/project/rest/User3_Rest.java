package com.civil.project.rest;

import com.civil.project.entity.ActeNaissance;
import com.civil.project.entity.RegistreNaiss;
import com.civil.project.entity.Utilisateur;
import com.civil.project.service.User3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user3")
public class User3_Rest {

    private User3_Service service;
    @Autowired
    public User3_Rest(User3_Service service) {
        this.service = service;
    }

    @GetMapping("/acte/naissance/{idActe}")
    public ActeNaissance getAct(@PathVariable int idActe)
    {
        return service.findById(idActe);
    }

    @GetMapping("/registre/naissance/{date}")
    public List<RegistreNaiss> getRegistrBydate(@PathVariable String date){
            return service.findByDate(date);
    }

    @GetMapping("/registres/naissance/")
    public List<RegistreNaiss> findRegistres(){
        System.out.println("hey ");
        return service.findRegistres();
    }

    @GetMapping("/registre/naissance/{idRegistre}")
    public RegistreNaiss getRegistres(@PathVariable int idRegistre)
    {
        return service.findByIdRegistre(idRegistre);
    }

    @DeleteMapping("/registre/naissance/delete/{id}")
    public String deleteRegistre(@PathVariable int id)
    {
        service.deleteRegistre(id);
        return "delete done";
    }

    @PostMapping("/registre/naissance/add")
    public String addRegistre(@RequestBody RegistreNaiss registre)
    {
        /*String[] dat=registre.getEdition().split("-");
        registre.setAnnee(Integer.parseInt(dat[0]));
        System.out.println(registre);*/
        service.addOrUpdateRegistre(registre);
        return "add done";
    }

    @PutMapping("/registre/naissance/update")
    public String UpdateRegistre(@RequestBody RegistreNaiss registre)
    {
        service.addOrUpdateRegistre(registre);
        return "update registre ";
    }

    /////// partie utilisateur
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getutilisateur()
    {
        return service.findUtilisateur();
    }

    @GetMapping("/utilisateur/{role}")
    public List<Utilisateur> findByRole(@PathVariable String role)
    {
        return service.findByRole(role);
    }

    @PutMapping("/utilisateur/update")
    public Utilisateur update(@RequestBody Utilisateur utilisateur)
    {
        service.addOrUpdateUser(utilisateur);
        return utilisateur;
    }
    @PostMapping("/utilisateur/add")
    public Utilisateur add(@RequestBody Utilisateur utilisateur)
    {
        service.addOrUpdateUser(utilisateur);
        return utilisateur;
    }
    @DeleteMapping("/utilisateur/delete/{id}")
    public String delete(@PathVariable int id)
        {
            service.deleteUtilisateur(id);
            return "delete with succes";
        }
}
