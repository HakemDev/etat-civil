package com.civil.project.deces.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="marginale_deces_fr")
@Data
@JsonIgnoreType
public class MarginaleDecesFr {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_marg_deces_fr")
    private int idMarginale;

    @Column(name = "marginale_deces_libelle_fr")
    private String libelle;

    @Column(name = "marginale_deces_txt_fr")
    private String texte;



    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "id_acte_deces")
    private ActeDeces acteDeces;

}
