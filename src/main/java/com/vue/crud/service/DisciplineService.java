package com.vue.crud.service;

import com.vue.crud.bo.Discipline;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;




public interface DisciplineService {




    /**
     * Méthode qui renvoie la liste des disciplines.
     * @return La liste des disciplines.
     */
    public List<Discipline> getAllDisciplines();


    /**
     * Méthode qui enregistre une nouvelle discipline en BDD.
     * @param discipline
     * @return La liste des disciplines mises à jour.
     */
    public Discipline createOneDiscipline(Discipline discipline);


    /**
     * Méthode qui supprime une discipline en BDD.
     * @param ident de la discipline
     */
    public void deleteOneDiscipline(Long ident);


    /**
     * Méthode qui inscrit un élève à un cours
     * @param identEleve, identCours
     */
    public void eleveInscription(Long identEleve, Long identCours);


    /**
     * Méthode qui récupère les cours suivis par un élève.
     * @param identEleve
     * @return liste des disciplines suivis par un Elève.
     */
    public List<Discipline> getCoursParEleve(Long identEleve);




}
