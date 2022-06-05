package com.civil.project.deces.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="marginale_deces_ar")
@Data
@JsonIgnoreType
public class MarginaleDecesAr {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_marg_deces_ar")
    private int idMargDecesAr;

    @Column(name = "marginale_deces_libelle_ar")
    private String marginaleDecesLibelleAr;

    @Column(name = "marginale_deces_txt_ar")
    private String marginaleDecesTxtAr;



    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "id_acte_deces")
    private ActeDeces acteDeces;

}
