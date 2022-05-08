package com.civil.project.jugesDeces.entity;

import com.civil.project.jugesDeces.entity.JugeDeces;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "registre_juges_deces")
@Data
public class RegistreJugesDeces {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registre")
    private int idRegistreDeces;

    @Column(name = "annee")
    private int annee;

    @Column(name = "date_edition")
    private String dateEdition;

    @Column(name = "nombre_juges")
    private int nombreJuges;

    @Column(name = "premier_numero")
    private int premierNumero;

    @Column(name = "dernier_numero")
    private int dernierNumero;

    @Column
    private int partie;

    @Column(name = "tribunal")
    private String tribunal;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
    mappedBy = "registreJugesDeces")
    @JsonIgnore
    private List<JugeDeces> jugeDeces;

}
