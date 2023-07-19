package com.vue.crud.controller;

import com.vue.crud.bo.Eleve;
import com.vue.crud.service.crudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api")
public class crudController {






    // ****************************** Injection de dépendance ******************************
    @Autowired
    crudService crudService;






    // ****************************** Méthodes ******************************

    /**
     * Get All.
     */
    @GetMapping("/crud-get-all")
    public List<Eleve> getAll()
    {
        return crudService.getAll();
    }



    /**
     * Get All.
     */
    @GetMapping("/crud-get-one/{id}")
    public Eleve getOne(@PathVariable("id") Long id)
    {
        return crudService.getOne(id);
    }



    /**
     * Méthode Delete
     * @param ident
     * @return
     */
    @GetMapping("/crud-delete-one/{ident}")
    public String deleteOne(@PathVariable("ident") Long ident)
    {
        return crudService.deleteOne(ident);
    }



    /**
     * Méthode Delete
     * @param eleve
     * @return elève créé
     */
    @PostMapping("/crud-create-one")
    public Eleve createOne(@RequestBody Eleve eleve)
    {
        return crudService.createOne(eleve);
    }



    /**
     * Méthode Put
     * @param eleve
     * @return elève modifié
     */
    @PutMapping("/crud-update-one")
    public Eleve putOne(@RequestBody Eleve eleve)
    {
        return crudService.putOne(eleve);
    }





}