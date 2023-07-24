package com.vue.crud.service.serviceImpl;

import com.vue.crud.bo.Discipline;
import com.vue.crud.bo.Eleve;
import com.vue.crud.repository.DisciplineRepository;
import com.vue.crud.repository.EleveRepository;
import com.vue.crud.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service
public class DisciplineServiceImpl implements DisciplineService {





    // ****************************** Injection de dépendance ******************************
    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    EleveRepository eleveRepository;





    // ****************************** Méthodes ******************************



    public List<Discipline> getAllDisciplines()
    {
        return disciplineRepository.findAll();
    }



    public Discipline createOneDiscipline(@RequestBody Discipline discipline)
    {
        return disciplineRepository.save(discipline);
    }


    public void deleteOneDiscipline(Long ident)
    {
        disciplineRepository.deleteById(ident);
    }


    @Override
    public void eleveInscription(Long identEleve, Long identCours)
    {
        Eleve eleveAInscrire = eleveRepository.findEleveParId(identEleve);
        Discipline discipline = disciplineRepository.findDisciplineById(identCours);
        Set<Eleve> listeEleves = discipline.getEleves();
        listeEleves.add(eleveAInscrire);
        discipline.setEleves(listeEleves);
        disciplineRepository.save(discipline);
    }


    @Override
    public List<Discipline> getCoursParEleve(Long identEleve)
    {
        List<Discipline> listeDisciplineParEleve = new ArrayList<Discipline>();
        List<Discipline> listeDiscipline = disciplineRepository.findAll();
        for(Discipline discipline : listeDiscipline)
        {
            for(Eleve eleve: discipline.getEleves())
            {
                if (Objects.equals(eleve.getNo_eleve(), identEleve)) {
                    listeDisciplineParEleve.add(discipline);
                }
            }
        }
        return listeDisciplineParEleve;
    }



}
