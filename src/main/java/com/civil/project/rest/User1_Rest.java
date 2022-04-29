package com.civil.project.rest;

import com.civil.project.entity.MargNaisAr;
import com.civil.project.entity.MargNaisFr;
import com.civil.project.service.User1_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marginale")
@RequiredArgsConstructor
public class User1_Rest {

    private final User1_Service service;
    @PostMapping("/fr/save")
    public MargNaisFr save(@RequestBody MargNaisFr marg_fr){
        service.saveOrUpdate_marginale_fr(marg_fr);
        return marg_fr;
    }
    @GetMapping("/fr/list")
    public List<MargNaisFr> listMarg_fr(){
        return service.getAllMarg_fr();
    }
    @DeleteMapping("/fr/delete/{id}")
    public String deleteMarg_fr(@PathVariable(value = "id") int id){
        service.delete_marginale_fr(id);
        return "deleted successfuly";
    }
    @GetMapping("/fr/IdActe/{id}")
    public List<MargNaisFr> listByActeId_Marg_fr(@PathVariable(value = "id") int id){
        return service.getById_acte_nais_Marg_fr(id);
    }
    //--------------------------arabe-------------------------------------//
    @PostMapping("/ar/save")
    public MargNaisAr save(@RequestBody MargNaisAr marg_ar){
        service.saveOrUpdate_marginale_ar(marg_ar);
        return marg_ar;
    }
    @GetMapping("/ar/list")
    public List<MargNaisAr> listMarg_ar(){
        System.out.println("hajaaaaaaar");
        return service.getAllMarg_ar();
    }
    @DeleteMapping("/ar/delete/{id}")
    public String deleteMarg_ar(@PathVariable(value = "id") int id){
        service.delete_marginale_ar(id);

        return "deleted successfuly";
    }
    @GetMapping("/ar/IdActe/{id}")
    public List<MargNaisAr> listByActeId_Marg_ar(@PathVariable(value = "id") int id){
        //System.out.println("hajaaaaaaar");
        return service.getById_acte_nais_Marg_ar(id);
    }


}
