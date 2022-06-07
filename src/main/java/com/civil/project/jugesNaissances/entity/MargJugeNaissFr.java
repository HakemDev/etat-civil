package com.civil.project.jugesNaissances.entity;

import com.civil.project.naissances.entity.ActeNaissance;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JoinColumn(name = "id_acte_juge_nais")
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ActeJugeNaissancee acteNaissance;

    @Column(name = "marginale_txt_fr")
    private String marginaleTxtFr;

    @Column(name = "libelle_marginale_fr")
    private String libelleMarginaleFr;
}
