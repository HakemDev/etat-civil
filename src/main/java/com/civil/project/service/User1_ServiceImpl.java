package com.civil.project.service;

import com.civil.project.dao.MargNaissArRepository;
import com.civil.project.dao.MargNaissFrRepository;
import com.civil.project.entity.MargNaisAr;
import com.civil.project.entity.MargNaisFr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class User1_ServiceImpl implements User1_Service{

    private final MargNaissArRepository marg_ar_rep;

    private final MargNaissFrRepository marg_fr_rep;

    @Override
    public void saveOrUpdate_marginale_fr(MargNaisFr marginale_fr) {
        marg_fr_rep.save(marginale_fr);

    }

    @Override
    public void delete_marginale_fr(int id) {
        marg_fr_rep.deleteById(id);

    }

    @Override
    public List<MargNaisFr> getAllMarg_fr() {
        System.out.println(marg_fr_rep.findAll());
        return marg_fr_rep.findAll();
    }

    @Override
    public List<MargNaisFr> getById_acte_nais_Marg_fr(int id) {
        return marg_fr_rep.findByActeNaissanceIdNaissance(id);
    }

    @Override
    public void saveOrUpdate_marginale_ar(MargNaisAr marginale_ar) {
        marg_ar_rep.save(marginale_ar);

    }
    @Override
    public void delete_marginale_ar(int id) {
        marg_ar_rep.deleteById(id);

    }

    @Override
    public List<MargNaisAr> getAllMarg_ar() {
        return marg_ar_rep.findAll();
    }

    @Override
    public List<MargNaisAr> getById_acte_nais_Marg_ar(int id) {
        return marg_ar_rep.findByActeNaissanceIdNaissance(id);
    }
}
