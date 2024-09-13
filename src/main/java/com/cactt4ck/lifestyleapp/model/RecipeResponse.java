package com.cactt4ck.lifestyleapp.model;

import com.cactt4ck.lifestyleapp.model.dto.IngredientQuantityDTO;
import lombok.Data;
import java.util.List;

@Data
public class RecipeResponse {
    private Long id;
    private String name;
    private Long calories;
    private Long proteins;
    private Long carbohydrates;
    private Long lipids;
    private String instructions;
    private List<IngredientQuantityDTO> ingredients;
}

