package com.civil.project.naissances.service;

import com.civil.project.naissances.entity.MargNaisAr;

import java.util.List;

public interface MarginalesArService {

    MargNaisAr addMarg(MargNaisAr margNaisAr);

    List<MargNaisAr> findMargNaisArByIdActe(Integer idActe);

    List<MargNaisAr> findAllMargNaisAr();

    MargNaisAr findMargNaisById(Integer id);

    MargNaisAr updateMarg(MargNaisAr margNaisAr);

    void deleteMarg(int id);

}
