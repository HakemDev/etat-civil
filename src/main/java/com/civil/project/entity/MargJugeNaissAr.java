package com.civil.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="marginale_juge_nais_ar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MargJugeNaissAr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_ar")
    private int id_marg_ar;
    @Column(name = "id_acte_juge_nais")
    private int idActeJugeNais;
    @Column(name = "marginale_txt_ar")
    private String marginale_txt_ar;
    @Column(name = "libelle_marginale_ar")
    private String libelle_marginale_ar;
}
