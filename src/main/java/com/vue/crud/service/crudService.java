package com.vue.crud.service;

import com.vue.crud.bo.Eleve;
import java.util.List;




public interface crudService {




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
    public Eleve getOne(Long ident);


    /**
     * Supprimer un élève
     * @param ident
     * @return Message qui indique la suppression de l'élève.
     */
    public String deleteOne(Long ident);


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






}
