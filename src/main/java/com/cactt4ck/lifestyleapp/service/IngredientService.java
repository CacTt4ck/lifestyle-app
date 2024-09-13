package com.cactt4ck.lifestyleapp.service;

import com.cactt4ck.lifestyleapp.model.Ingredient;
import com.cactt4ck.lifestyleapp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // Ajouter un nouvel ingrédient
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    // Obtenir tous les ingrédients
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    // Obtenir un ingrédient par ID
    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    // Mettre à jour un ingrédient existant
    public Ingredient updateIngredient(Long id, Ingredient ingredientDetails) {
        return ingredientRepository.findById(id).map(ingredient -> {
            ingredient.setName(ingredientDetails.getName());
            ingredient.setStock(ingredientDetails.getStock());
            ingredient.setUnit(ingredientDetails.getUnit());
            return ingredientRepository.save(ingredient);
        }).orElseThrow(() -> new RuntimeException("Ingredient not found with ID: " + id));
    }

    // Supprimer un ingrédient
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
