package com.vue.crud.repository;

import com.vue.crud.bo.Discipline;
import com.vue.crud.bo.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,Long> {

    @Query("SELECT d FROM Discipline d WHERE d.id = :id")
    Discipline findDisciplineById(@Param("id") Long identCours);



}
