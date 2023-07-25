package com.vue.crud.bo.rapport;

import com.vue.crud.bo.Note;

import java.util.List;
import java.util.Set;

public class DetailNotesParEleve {





    // **************************** Attributs ****************************

    private Long no_eleve;

    private String nom;

    private String prenom;

    private String maison;

    private List<Note> listeNotes;





    // **************************** Constructeur ****************************


    public DetailNotesParEleve() {}

    public DetailNotesParEleve(Long no_eleve, String nom, String prenom, String maison, List<Note> listeNotes) {
        this.no_eleve = no_eleve;
        this.nom = nom;
        this.prenom = prenom;
        this.maison = maison;
        this.listeNotes = listeNotes;
    }





    // **************************** Getter / Setter ****************************


    public Long getNo_eleve() {
        return no_eleve;
    }

    public void setNo_eleve(Long no_eleve) {
        this.no_eleve = no_eleve;
    }

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

    public String getMaison() {
        return maison;
    }

    public void setMaison(String maison) {
        this.maison = maison;
    }

    public List<Note> getListeNotes() {
        return listeNotes;
    }

    public void setListeNotes(List<Note> listeNotes) {
        this.listeNotes = listeNotes;
    }






}


