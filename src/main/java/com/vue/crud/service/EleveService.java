package com.vue.crud.service;

import com.vue.crud.bo.Eleve;
import com.vue.crud.bo.Maison;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;




public interface EleveService {




    // ****************************** Méthodes ******************************


    /**
     * Afficher tous les élèves
     * @return liste des élèves
     */
    public List<Eleve> getAll();


    /**
     * Afficher un élève
     * @return un élève
     */
    public Eleve getOne(Long id);


    /**
     * Supprimer un élève
     * @param ident
     * @return Message qui indique la suppression de l'élève.
     */
    public void deleteOne(Long ident);


    /**
     * Créer un élève
     * @param eleve
     * @return L'élève créé.
     */
    public Eleve createOne(Eleve eleve);


    /**
     * Modifier un élève
     * @return Elève modifié.
     */
    public Eleve putOne(Eleve eleve);


    /**
     * Récupérer les maisons de Poudlard.
     * @return Liste des maisons.
     */
    public List<Maison> getMaisons();


    /**
     * Ajouter une note
     * @param identEleve, identCours, note
     */
    public void addNote(Long identEleve, Long identCours, int note);






}
