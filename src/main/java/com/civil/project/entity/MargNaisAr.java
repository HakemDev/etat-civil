package com.civil.project.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="marginale_nais_ar" )
@Data
public class MargNaisAr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_ar")
    private int id_marg_ar;
    @Column(name = "id_acte_nais")
    private int idActeNais;
    @Column(name = "marginale_txt_ar")
    private String marginale_txt_ar;
    @Column(name = "libelle_marginale_ar")
    private String libelle_marginale_ar;

    @Override
    public String toString() {
        return "MargNaisAr{" +
                "id_marg_ar=" + id_marg_ar +
                ", id_acte_nais=" + idActeNais +
                ", marginale_txt_ar='" + marginale_txt_ar + '\'' +
                ", libelle_marginale_ar='" + libelle_marginale_ar + '\'' +
                '}';
    }

    public MargNaisAr() {
    }
}
