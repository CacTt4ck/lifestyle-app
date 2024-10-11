package com.cactt4ck.lifestyleapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeDTO {

    private String name;
    private Long carbohydrates;
    private Long proteins;
    private Long lipids;
    private Long calories;
    private String instructions;
    private String image;

    // Liste des ingrédients associés avec quantité
    private List<IngredientDTO> ingredients;
}

