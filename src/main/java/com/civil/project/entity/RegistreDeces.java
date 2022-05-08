package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="registre_deces")
@Data
@JsonIgnoreType
public class RegistreDeces {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registre_deces")
    private int idRegistreDeces;

    @Column(name = "annee")
    private int annee;

    @Column(name = "date_edition")
    private String dateEdition;

    @Column(name = "nombre_actes_deces")
    private int nombreActeDeces;

    @Column(name = "premier_numero")
    private int premierNumero;

    @Column(name = "dernier_numero")
    private int dernierNumero;

    @Column(name = "tribunal")
    private String tribunal;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="id_registre_deces")
    // todo remove joincolumn
    private List<ActeDeces> actesDeces;





}
