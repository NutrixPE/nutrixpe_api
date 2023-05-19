package com.nutrixpe.nutrixpe_api.controller;

import com.nutrixpe.nutrixpe_api.dto.EatingPlanDTO;
import com.nutrixpe.nutrixpe_api.model.EatingPlan;
import com.nutrixpe.nutrixpe_api.service.impl.EatingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Notación para indicar que es un controlador de tipo Rest
@RestController
//Notación para indicar el contexto de nuestros endpoint es decir /torre/nombreServicio
@RequestMapping("/eatingPlan")
//URL que permitimos que consuman nuestras APIS
//En caso de querer permitir todos los origentes ponemos en lugar de la URL un *
//@CrossOrigin(origins = "http://localhost:4200")
public class EatingPlanController {
    @Autowired
    EatingPlanService _service;

    //Se le indica el tipo de petición asi como el nombre del servicio
    @GetMapping("/listar")
    public ResponseEntity<List<EatingPlan>> getAll(){

        List<EatingPlan> list = _service.getAll();
        return new ResponseEntity<List<EatingPlan>>(list, HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<EatingPlan> getId(@PathVariable("id") long id){

        if (!_service.existsById(id))
            return new ResponseEntity("No existe", HttpStatus.NOT_FOUND);

        EatingPlan result = _service.onFindById(id).get();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    //Con el ? le decimos que no devulve ningún tipo de dato
    //El body va a ser un JSON
    //Aqui se usa el apache commons lang
    // El import de StringUtils es import org.apache.commons.lang3.StringUtils;
    @PostMapping("/create")
    public ResponseEntity<?> onCreateEatingPlan(@RequestBody EatingPlanDTO dto){
        EatingPlan obj = new EatingPlan(null, dto.getNota_desayuno(), dto.getNota_media_mañana(),
                                        dto.getNota_merienda(), dto.getNota_almuerzo(),dto.getNota_cena(),
                                        dto.getNota_snack_nocturno());
        _service.onCreate(obj);
        return new ResponseEntity("Datos Guardados", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> onDelete(@PathVariable("id") long id){
        if (!_service.existsById(id))
            return new ResponseEntity("No existe", HttpStatus.NOT_FOUND);

        _service.onDelete(id);
        return new ResponseEntity("Información eliminada", HttpStatus.OK);
    }

}
