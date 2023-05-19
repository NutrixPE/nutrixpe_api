package com.nutrixpe.nutrixpe_api.service.impl;

import com.nutrixpe.nutrixpe_api.model.EatingPlan;
import com.nutrixpe.nutrixpe_api.repository.EatingPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Notación para indicar que es un servicio
@Service
//Asegura que toda la data requerida este segura hasta que la transacción termine
//Recomiendo leer acerca de esta notación (es un mundo completo jeje)
@Transactional
public class EatingPlanService {

    @Autowired
    EatingPlanRepository eatingPlanRepository;

    //Por defecto el repositorio al extender de JPA trae el metodo por defecto

    public void onCreate(EatingPlan request){
        eatingPlanRepository.save(request);
    }
    public List<EatingPlan> getAll(){
        return  eatingPlanRepository.findAll();
    }

    public boolean existsById(Long id){
        return eatingPlanRepository.existsById(id);
    }

    public Optional<EatingPlan> onFindById(long id){
        return  eatingPlanRepository.findById(id);
    }

    public void onDelete(long id){
        eatingPlanRepository.deleteById(id);
    }

}
