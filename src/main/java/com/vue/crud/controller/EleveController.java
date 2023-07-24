package com.vue.crud.controller;

import com.vue.crud.bo.Eleve;
import com.vue.crud.bo.Maison;
import com.vue.crud.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/eleve")
public class EleveController {






    // ****************************** Injection de dépendance ******************************
    @Autowired
    EleveService eleveService;






    // ****************************** Méthodes ******************************


    /**
     * Get All.
     */
    @GetMapping("/get-all")
    public List<Eleve> getAllEleves()
    {
        return eleveService.getAll();
    }


    /**
     * Get All.
     */
    @GetMapping("/get-one/{id}")
    public Eleve getOneEleve(@PathVariable("id") Long id)
    {
        return eleveService.getOne(id);
    }


    /**
     * Méthode Delete
     * @param ident
     * @return
     */
    @PostMapping("/delete-one/{ident}")
    public void deleteOneEleve(@PathVariable("ident") Long ident)
    {
        eleveService.deleteOne(ident);
    }


    /**
     * Controller pour Supprimer un élève
     * @param eleve
     * @return elève créé
     */
    @PostMapping("/create-one")
    public Eleve createOneEleve(@RequestBody Eleve eleve)
    {
        return eleveService.createOne(eleve);
    }


    /**
     * Controller pour Modifier un élève
     * @param eleve
     * @return elève modifié
     */
    @PutMapping("/update-one")
    public Eleve putOneEleve(@RequestBody Eleve eleve)
    {
        return eleveService.putOne(eleve);
    }


    /**
     * Controller qui renvoie la liste des maisons de Poudlard.
     * @return liste des Maisons.
     */
    @GetMapping("/get-maisons")
    public List<Maison> getMaisons()
    {
        return eleveService.getMaisons();
    }


    /**
     * Controller qui renvoie la liste des maisons de Poudlard.
     * @return liste des Maisons.
     */
    @PostMapping("/ajout_note/{identEleve}/{identCours}/{note}")
    public void addNote(@PathVariable("identEleve") Long identEleve, @PathVariable("identCours") Long identCours, @PathVariable("note") int note)
    {
        eleveService.addNote(identEleve, identCours, note);
    }



    


}