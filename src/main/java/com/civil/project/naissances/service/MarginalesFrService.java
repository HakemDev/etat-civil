package com.civil.project.naissances.service;

import com.civil.project.naissances.entity.MargNaisFr;

import java.util.List;

public interface MarginalesFrService {

    MargNaisFr addMarg(MargNaisFr margNaisAr);

    List<MargNaisFr> findMargNaisFrByIdActe(Integer idActe);

    List<MargNaisFr> findAllMargNaisFr();

    MargNaisFr findMargNaisById(Integer id);

}
