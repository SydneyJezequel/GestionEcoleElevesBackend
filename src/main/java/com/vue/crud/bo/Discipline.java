package com.vue.crud.bo;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name="discipline")
public class Discipline {






    // **************************** Attributs ****************************

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="no_discipline")
    private Long id;

    @Column(nullable = false, name="discipline")
    private String discipline;

    @Column(nullable = false, name="nom_professeur")
    private String nomProfesseur;

    @Column(nullable = false, name="prenom_professeur")
    private String prenomProfesseur;

    @Column(name="eleves")
    @ManyToMany
    @JoinTable(
            name = "entity_eleve",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id")
    )
    private Set<Eleve> eleves;





    // **************************** Constructeur ****************************
    public Discipline() {}

    public Discipline(String discipline, String nomProfesseur, String prenomProfesseur, Set<Eleve> eleves) {
        this.discipline = discipline;
        this.nomProfesseur = nomProfesseur;
        this.prenomProfesseur = prenomProfesseur;
        this.eleves = eleves;
    }

    public Discipline(Long id, String discipline, String nomProfesseur, String prenomProfesseur, Set<Eleve> eleves) {
        this.id = id;
        this.discipline = discipline;
        this.nomProfesseur = nomProfesseur;
        this.prenomProfesseur = prenomProfesseur;
        this.eleves = eleves;
    }





    // **************************** Getter / Setter ****************************
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getNomProfesseur() {
        return nomProfesseur;
    }

    public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }

    public String getPrenomProfesseur() {
        return prenomProfesseur;
    }

    public void setPrenomProfesseur(String prenomProfesseur) {
        this.prenomProfesseur = prenomProfesseur;
    }

    public Set<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(Set<Eleve> eleves) {
        this.eleves = eleves;
    }




}


