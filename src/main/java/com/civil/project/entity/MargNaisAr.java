package com.civil.project.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="marginale_nais_ar" )
@Data
@NoArgsConstructor
public class MargNaisAr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_ar")
    private int idMarginalAr;

    @JoinColumn(name = "id_acte_nais")
    @ManyToOne
    private ActeNaissance acteNaissance;

    @Column(name = "marginale_txt_ar")
    private String marginaleTxtAr;

    @Column(name = "libelle_marginale_ar")
    private String libelleMarginaleAr;

}
