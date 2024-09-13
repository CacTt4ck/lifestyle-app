package com.cactt4ck.lifestyleapp.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {

    private String name;
    private Long carbohydrates;
    private Long proteins;
    private Long lipids;
    private Long calories;
    private String instructions;

    // Liste des ingrédients associés avec quantité
    private List<IngredientDTO> ingredients;
}

