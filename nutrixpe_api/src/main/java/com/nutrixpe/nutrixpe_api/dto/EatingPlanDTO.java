package com.nutrixpe.nutrixpe_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EatingPlanDTO {

    private Long id;
    private String nota_desayuno;
    private String nota_media_mañana;
    private String nota_merienda;
    private String nota_almuerzo;
    private String nota_cena;
    private String nota_snack_nocturno;

}
