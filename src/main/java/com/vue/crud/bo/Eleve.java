package com.vue.crud.bo;

import jakarta.persistence.*;
import java.util.Date;




@Entity
@Table(name="Eleve")
public class Eleve {






    // **************************** Attributs ****************************

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="no_eleve")
    private Long no_eleve;

    @Column(nullable = false, name="nom")
    private String nom;

    @Column(nullable = false, name="prenom")
    private String prenom;

    @Column(nullable = false, name="date_naissance")
    private Date dateNaissance;

    @Column(nullable = false, name="maison")
    private String maison;

    @Column(nullable = false, name="annee")
    private int annee;






    // **************************** Constructeur ****************************
    public Eleve(){};

    public Eleve(Long no_eleve, String nom, String prenom, Date dateNaissance, String maison, int annee) {
        this.no_eleve = no_eleve;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.maison = maison;
        this.annee = annee;
    }







    //  **************************** Getter / Setter  ****************************


    public Long getNo_eleve() { return no_eleve; }

    public void setNo_eleve(Long no_eleve) { this.no_eleve = no_eleve; }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMaison() { return maison; }

    public void setMaison(String maison) { this.maison = maison; }

    public int getAnnee() { return annee; }

    public void setAnnee(int annee) { this.annee = annee; }





}

