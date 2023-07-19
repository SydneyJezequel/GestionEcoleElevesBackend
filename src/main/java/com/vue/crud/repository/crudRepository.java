package com.vue.crud.repository;

import com.vue.crud.bo.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface crudRepository extends JpaRepository <Eleve,Long>{

    @Query("SELECT e FROM Eleve e WHERE e.no_eleve = :id")
    Eleve findEleveParId(@Param("id") Long id);




}
