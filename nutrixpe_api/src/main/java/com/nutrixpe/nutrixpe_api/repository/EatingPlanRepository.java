package com.nutrixpe.nutrixpe_api.repository;


import com.nutrixpe.nutrixpe_api.model.EatingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EatingPlanRepository extends JpaRepository<EatingPlan, Long> {
    // Con @Repository le indico los metodos principales select, create, update, delete

    //Convención sobre convicción
    //CrudRepository permite realizar busquedas por campo según la entidad
}
