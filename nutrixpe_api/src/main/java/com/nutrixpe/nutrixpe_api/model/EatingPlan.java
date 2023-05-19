package com.nutrixpe.nutrixpe_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "plan_alimentacion")
public class EatingPlan {
    //Llave primaria de la tabla
    @Id
    //Se le indica que el campo ID es Autonumerico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nota_desayuno;
    private String nota_media_mañana;
    private String nota_merienda;
    private String nota_almuerzo;
    private String nota_cena;
    private String nota_snack_nocturno;
}
