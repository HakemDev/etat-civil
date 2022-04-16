package com.civil.project.service;

import com.civil.project.entity.Marg_nais_ar;
import com.civil.project.entity.Marg_nais_fr;

import java.util.List;

public interface User1_Service {
    public void saveOrUpdate_marginale_fr(Marg_nais_fr marginale_fr);
    public void  delete_marginale_fr(int id);
    public List<Marg_nais_fr> getAllMarg_fr();
    public List<Marg_nais_fr> getById_acte_nais_Marg_fr(int id);

    public void saveOrUpdate_marginale_ar(Marg_nais_ar marginale_ar);
    public void  delete_marginale_ar(int id);
    public List<Marg_nais_ar> getAllMarg_ar();
    public List<Marg_nais_ar> getById_acte_nais_Marg_ar(int id);

}
