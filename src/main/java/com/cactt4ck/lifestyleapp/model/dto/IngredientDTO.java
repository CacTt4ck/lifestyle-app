package com.cactt4ck.lifestyleapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private Long ingredientId;  // ID de l'ingrédient
    private double quantity;    // Quantité de l'ingrédient

}

