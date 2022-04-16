package com.civil.project.entity;


import javax.persistence.*;

@Entity
@Table(name ="marginale_nais_ar" )
public class Marg_nais_ar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marg_ar")
    private int id_marg_ar;
    @Column(name = "id_acte_nais")
    private int idActeNais;
    @Column(name = "marginale_txt_ar")
    private String marginale_txt_ar;
    @Column(name = "libelle_marginale_ar")
    private String libelle_marginale_ar;

    public int getId_marg_ar() {
        return id_marg_ar;
    }

    public void setId_marg_ar(int id_marg_ar) {
        this.id_marg_ar = id_marg_ar;
    }

    public int getIdActeNais() {
        return idActeNais;
    }

    public void setIdActeNais(int id_acte_nais) {
        this.idActeNais = id_acte_nais;
    }

    public String getMarginale_txt_ar() {
        return marginale_txt_ar;
    }

    public void setMarginale_txt_ar(String marginale_txt_ar) {
        this.marginale_txt_ar = marginale_txt_ar;
    }

    public String getLibelle_marginale_ar() {
        return libelle_marginale_ar;
    }

    public void setLibelle_marginale_ar(String libelle_marginale_ar) {
        this.libelle_marginale_ar = libelle_marginale_ar;
    }

    public Marg_nais_ar(int id_marg_ar, int id_acte_nais, String marginale_txt_ar, String libelle_marginale_ar) {
        this.id_marg_ar = id_marg_ar;
        this.idActeNais = id_acte_nais;
        this.marginale_txt_ar = marginale_txt_ar;
        this.libelle_marginale_ar = libelle_marginale_ar;
    }

    public Marg_nais_ar(int id_acte_nais, String marginale_txt_ar, String libelle_marginale_ar) {
        this.idActeNais = id_acte_nais;
        this.marginale_txt_ar = marginale_txt_ar;
        this.libelle_marginale_ar = libelle_marginale_ar;
    }

    @Override
    public String toString() {
        return "Marg_nais_ar{" +
                "id_marg_ar=" + id_marg_ar +
                ", id_acte_nais=" + idActeNais +
                ", marginale_txt_ar='" + marginale_txt_ar + '\'' +
                ", libelle_marginale_ar='" + libelle_marginale_ar + '\'' +
                '}';
    }

    public Marg_nais_ar() {
    }
}
