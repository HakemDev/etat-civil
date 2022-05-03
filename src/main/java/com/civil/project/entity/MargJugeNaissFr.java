package com.civil.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="marginale_juge_nais_fr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MargJugeNaissFr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_fr")
    private int id_marg_fr;

    @Column(name = "id_acte_juge_nais")
    private int idActeJugeNais;

    @Column(name = "marginale_txt_fr")
    private String marginale_txt_fr;

    @Column(name = "libelle_marginale_fr")
    private String libelle_marginale_fr;
}
