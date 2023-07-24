package com.vue.crud.controller;

import com.vue.crud.bo.Discipline;
import com.vue.crud.bo.Eleve;
import com.vue.crud.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/discipline")
public class DisciplineController {








    // ****************************** Injection de dépendance ******************************
    @Autowired
    DisciplineService disciplineService;






    // ****************************** Méthodes ******************************

    /**
     * Controller pour récupérer la liste de toutes les disciplines.
     * @return la liste des disciplines
     */
    @GetMapping("/get-all")
    public List<Discipline> getAllDisciplines()
    {
        return disciplineService.getAllDisciplines();
    }



    /**
     * Controller pour créer une discipline.
     * @param discipline)
     * @return la discipline ajoutée en BDD.
     */
    @PostMapping("/create-one")
    public Discipline createOneDiscipline(@RequestBody Discipline discipline)
    {
        return disciplineService.createOneDiscipline(discipline);
    }



    /**
     * Controller pour supprimer une discipline.
     * @param ident de la discipline)
     */
    @PostMapping("/delete-one/{ident}")
    public void deleteOneDiscipline(@PathVariable("ident") Long ident)
    {
        disciplineService.deleteOneDiscipline(ident);
    }



    /**
     * Controller qui inscrit les élèves à un cours.
     * @param identEleve, identCours
     * @return elève créé
     */
    @PostMapping("/inscription/{identEleve}/{identCours}")
    public void eleveInscription(@PathVariable("identEleve") Long identEleve, @PathVariable("identCours") Long identCours)
    {
        disciplineService.eleveInscription(identEleve, identCours);
    }



    /**
     * Controller pour récupérer la liste de toutes les disciplines.
     * @return la liste des disciplines
     */
    @GetMapping("/cours_suivi_par_eleve/{identEleve}")
    public List<Discipline> getCoursSuivis(@PathVariable("identEleve") Long identEleve)
    {
        return disciplineService.getCoursParEleve(identEleve);
    }





}

