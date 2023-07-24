package com.vue.crud.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;


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

    @Column(name="notes")
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "note_eleve",
            joinColumns = @JoinColumn(name = "no_eleve"),
            inverseJoinColumns = @JoinColumn(name = "no_note")
    )
    private Set<Note> notes;

    @Column(name="moyenne_generale")
    private Integer moyenneGenerale;





    // **************************** Constructeur ****************************
    public Eleve(){};

    public Eleve(String nom, String prenom, Date dateNaissance, String maison, int annee, Set<Note> notes, Integer moyenneGenerale) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.maison = maison;
        this.annee = annee;
        this.notes = notes;
        this.moyenneGenerale = moyenneGenerale;
    }

    public Eleve(Long no_eleve, String nom, String prenom, Date dateNaissance, String maison, int annee, Set<Note> notes, Integer moyenneGenerale) {
        this.no_eleve = no_eleve;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.maison = maison;
        this.annee = annee;
        this.notes = notes;
        this.moyenneGenerale = moyenneGenerale;
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

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Integer getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(Integer moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }
}



