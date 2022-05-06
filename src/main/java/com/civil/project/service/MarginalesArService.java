package com.civil.project.service;

import com.civil.project.entity.MargNaisAr;

import java.util.List;

public interface MarginalesArService {

    MargNaisAr addMarg(MargNaisAr margNaisAr);

    List<MargNaisAr> findMargNaisArByIdActe(Integer idActe);

    List<MargNaisAr> findAllMargNaisAr();

    MargNaisAr findMargNaisById(Integer id);

    MargNaisAr updateMarg(MargNaisAr margNaisAr);

}
