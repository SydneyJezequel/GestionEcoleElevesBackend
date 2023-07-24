package com.vue.crud.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
@Table(name="Note")
public class Note {






    // **************************** Attributs ****************************

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="no_note")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Discipline discipline;

    @Column(nullable = false, name="note")
    private int note;





    // **************************** Constructeur ****************************
    public Note() {}

    public Note(Discipline discipline, int note) {
        this.discipline = discipline;
        this.note = note;
    }

    public Note(Long id, Discipline discipline, int note) {
        this.id = id;
        this.discipline = discipline;
        this.note = note;
    }





    // **************************** Getter / Setter ****************************

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }




}
