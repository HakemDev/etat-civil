package com.civil.project.service;

import com.civil.project.entity.MargNaisAr;
import com.civil.project.entity.MargNaisFr;

import java.util.List;

 public interface User1_Service {
     void saveOrUpdate_marginale_fr(MargNaisFr marginale_fr);
     void  delete_marginale_fr(int id);
     List<MargNaisFr> getAllMarg_fr();
     List<MargNaisFr> getById_acte_nais_Marg_fr(int id);

     void saveOrUpdate_marginale_ar(MargNaisAr marginale_ar);
     void  delete_marginale_ar(int id);
     List<MargNaisAr> getAllMarg_ar();
     List<MargNaisAr> getById_acte_nais_Marg_ar(int id);

}
