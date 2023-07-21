package com.vue.crud.service.serviceImpl;

import com.vue.crud.bo.Maison;
import com.vue.crud.repository.crudRepository;
import com.vue.crud.service.crudService;
import com.vue.crud.bo.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class crudServiceImpl implements crudService {





    // ****************************** Injection de dépendance ******************************
    @Autowired
    crudRepository crudRepository;





    // ****************************** Méthodes ******************************


    @Override
    public List<Eleve> getAll()
    {
        for(Eleve e : crudRepository.findAll())
        {
            System.out.println(e.getNom());
        }
        return crudRepository.findAll();
    }


    @Override
    public Eleve getOne(Long id)
    {
        return crudRepository.findEleveParId(id);
    }


    @Override
    public String deleteOne(Long ident)
    {
        Eleve eleveSupprime = crudRepository.findEleveParId(ident);
        crudRepository.deleteById(ident);
        return "L'élève : "+ eleveSupprime.getNom() +" a été supprimé";
    }


    @Override
    public Eleve createOne(Eleve eleve)
    {
        return crudRepository.save(eleve);
    }


    @Override
    public Eleve putOne(Eleve eleve)
    {
        Eleve eleveAModifier = crudRepository.findEleveParId(eleve.getNo_eleve());
        if(eleveAModifier != null)
        {
            eleveAModifier.setMaison(eleve.getMaison());
            eleveAModifier.setAnnee(eleve.getAnnee());
            eleveAModifier.setNom(eleve.getNom());
            eleveAModifier.setPrenom(eleve.getPrenom());
            eleveAModifier.setDateNaissance(eleve.getDateNaissance());
            crudRepository.save(eleveAModifier);
        }

        return eleveAModifier;
    }


    public List<Maison> getMaisons()
    {
        List<Maison> listeMaison = new ArrayList<>();
        listeMaison.add(Maison.SERPENTARD);
        listeMaison.add(Maison.GRYFONDOR);
        listeMaison.add(Maison.SERDAIGLE);
        listeMaison.add(Maison.POUFSOUFLE);
        return listeMaison;
    }

}
