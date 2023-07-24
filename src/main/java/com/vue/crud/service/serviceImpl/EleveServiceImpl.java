package com.vue.crud.service.serviceImpl;

import com.vue.crud.bo.Discipline;
import com.vue.crud.bo.Maison;
import com.vue.crud.bo.Note;
import com.vue.crud.repository.DisciplineRepository;
import com.vue.crud.repository.EleveRepository;
import com.vue.crud.repository.NoteRepository;
import com.vue.crud.service.EleveService;
import com.vue.crud.bo.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class EleveServiceImpl implements EleveService {





    // ****************************** Injection de dépendance ******************************
    @Autowired
    EleveRepository eleveRepository;

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    NoteRepository noteRepository;




    // ****************************** Méthodes ******************************


    @Override
    public List<Eleve> getAll()
    {
        for(Eleve e : eleveRepository.findAll())
        {
            System.out.println(e.getNom());
        }
        return eleveRepository.findAll();
    }


    @Override
    public Eleve getOne(Long id)
    {
        return eleveRepository.findEleveParId(id);
    }


    @Override
    public void deleteOne(Long ident)
    {
        Eleve eleveSupprime = eleveRepository.findEleveParId(ident);
        eleveRepository.deleteById(ident);
    }


    @Override
    public Eleve createOne(Eleve eleve)
    {
        return eleveRepository.save(eleve);
    }


    @Override
    public Eleve putOne(Eleve eleve)
    {
        Eleve eleveAModifier = eleveRepository.findEleveParId(eleve.getNo_eleve());
        if(eleveAModifier != null)
        {
            eleveAModifier.setMaison(eleve.getMaison());
            eleveAModifier.setAnnee(eleve.getAnnee());
            eleveAModifier.setNom(eleve.getNom());
            eleveAModifier.setPrenom(eleve.getPrenom());
            eleveAModifier.setDateNaissance(eleve.getDateNaissance());
            eleveRepository.save(eleveAModifier);
        }

        return eleveAModifier;
    }


    @Override
    public List<Maison> getMaisons()
    {
        List<Maison> listeMaison = new ArrayList<>();
        listeMaison.add(Maison.SERPENTARD);
        listeMaison.add(Maison.GRYFONDOR);
        listeMaison.add(Maison.SERDAIGLE);
        listeMaison.add(Maison.POUFSOUFLE);
        return listeMaison;
    }


    @Override
    public void addNote(Long identEleve, Long identCours, int note)
    {
        // Attributs :
        Discipline disciplineNote = disciplineRepository.findDisciplineById(identCours);
        Eleve eleveNote = eleveRepository.findEleveParId(identEleve);
        Set<Note> listeNotes = eleveNote.getNotes();
        int moyenneGenerale = 0;
        int nombreNotes = 0;
        int sommeNotes = 0;

        // Traitements :
        // 1- Ajout de la nouvelle note :
        Note nouvelleNote = new Note(disciplineNote, note);
        noteRepository.save(nouvelleNote);
        listeNotes.add(nouvelleNote);
        eleveNote.setNotes(listeNotes);
        // 2- Calcul de la moyennne Générale :
        for (Note n : listeNotes)
        {
            sommeNotes = sommeNotes + n.getNote();
            nombreNotes++;
        }
        moyenneGenerale = sommeNotes/nombreNotes;
        eleveNote.setMoyenneGenerale(moyenneGenerale);
        // 3- Sauvegarde de l'Elève mis à jour :
        eleveRepository.save(eleveNote);
    }





}
