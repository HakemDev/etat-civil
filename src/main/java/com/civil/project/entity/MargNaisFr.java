package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name ="marginale_nais_fr" )
@JsonIgnoreType
@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MargNaisFr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_fr")
    private int id_marg_fr;

    @Column(name = "id_acte_nais")
    private int idActeNais;

    @Column(name = "marginale_txt_fr")
    private String marginaleTxtFr;

    @Column(name = "libelle_marginale_fr")
    private String libelleMarginaleFr;


}
