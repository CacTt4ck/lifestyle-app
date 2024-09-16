package com.cactt4ck.lifestyleapp.model.dto;

import lombok.Data;

@Data
public class IngredientQuantityDTO {
    private Long ingredientId;
    private String name;
    private double quantity;
    private double stock;
    private String unit;

    public IngredientQuantityDTO(Long ingredientId, String name, double quantity, double stock, String unit) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.quantity = quantity;
        this.stock = stock;
        this.unit = unit;
    }
}

