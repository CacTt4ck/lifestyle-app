package com.cactt4ck.lifestyleapp.model.dto;

import lombok.Data;

@Data
public class IngredientQuantityDTO {
    private Long ingredientId;
    private double quantity;

    public IngredientQuantityDTO(Long ingredientId, double quantity) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }
}

