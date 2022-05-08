package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "marginale_juge_deces_ar")
@Data
@JsonIgnoreType
public class MarginaleJugeDecesAr {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int idMarginale;

    @Column
    private String libelle;

    @Column
    private String texte;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "id_juge_deces")
    private JugeDeces jugeDeces;
}
