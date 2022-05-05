package com.civil.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "registre")
@AllArgsConstructor
@NoArgsConstructor
public class RegistreNaiss {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registre")
    private int idRegistre;

    //@Column(name = "id_utilisateur")
    //private int idUtilisateur;

    @Column(name = "tribunal")
    private String tribunal;

    @Column(name = "annee")
    private int annee;

    @Column(name = "date_edition")
    private Date dateEdition;

    @Column(name = "partie")
    private int partie;

    public int getNombreActes() {
        return actes == null ? 0 : actes.size();
    }

    public int getDernierNumero() {
        if(actes == null || actes.isEmpty())
            return 0;
        return actes.get(actes.size()-1).getNumeroActe();
    }

    public int getPremierNumero() {
        if(actes == null || actes.isEmpty())
            return 0;
        return actes.get(0).getNumeroActe();
    }

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.PERSIST,
                    CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="id_registre")
    @JsonIgnore
    private List<ActeNaissance> actes;

    public void add(ActeNaissance acte)
    {
        if(actes==null){
            actes=new ArrayList<>();
        }
        actes.add(acte);
//    /registre.setUtilisateur(this);
    }
}
