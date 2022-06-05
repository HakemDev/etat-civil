package com.civil.project.naissances.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name ="marginale_nais_fr" )
@Data
@NoArgsConstructor
public class MargNaisFr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_fr")
    private int id_marg_fr;

    @JoinColumn(name = "id_acte_nais")
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ActeNaissance acteNaissance;

    @Column(name = "marginale_txt_fr")
    private String marginaleTxtFr;

    @Column(name = "libelle_marginale_fr")
    private String libelleMarginaleFr;


}
