package com.civil.project.jugesNaissances.entity;

import com.civil.project.naissances.entity.ActeNaissance;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int idMarginalAr;

    @JoinColumn(name = "id_acte_juge_nais")
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ActeJugeNaissancee acteNaissance;

    @Column(name = "marginale_txt_ar")
    private String marginaleTxtAr;

    @Column(name = "libelle_marginale_ar")
    private String libelleMarginaleAr;

}
