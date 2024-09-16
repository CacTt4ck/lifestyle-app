package com.cactt4ck.lifestyleapp.service;

import com.cactt4ck.lifestyleapp.model.*;
import com.cactt4ck.lifestyleapp.model.dto.IngredientDTO;
import com.cactt4ck.lifestyleapp.model.dto.IngredientQuantityDTO;
import com.cactt4ck.lifestyleapp.model.dto.RecipeDTO;
import com.cactt4ck.lifestyleapp.repository.IngredientRepository;
import com.cactt4ck.lifestyleapp.repository.RecipeIngredientRepository;
import com.cactt4ck.lifestyleapp.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private static final Logger log = LoggerFactory.getLogger(RecipeService.class);
    private final RecipeRepository recipeRepository;
    private final RecipeIngredientService recipeIngredientService;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeIngredientService recipeIngredientService, RecipeIngredientRepository recipeIngredientRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientService = recipeIngredientService;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
    }

    // Ajouter une nouvelle recette avec ses ingrédients
    public Recipe addRecipe(Recipe recipe, List<IngredientDTO> ingredientDTOs) {
        // Sauvegarder la recette d'abord
        Recipe savedRecipe = recipeRepository.save(recipe);
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        // Associer les ingrédients à la recette
        for (IngredientDTO ingredientDTO : ingredientDTOs) {
            Long ingredientId = ingredientDTO.getIngredientId();

            // Vérifier si l'ingrédient existe dans la base de données
            Optional<Ingredient> ingredientOpt = ingredientRepository.findById(ingredientId);
            if (ingredientOpt.isEmpty()) {
                throw new RuntimeException("Ingredient not found with ID: " + ingredientId);
            }

            Ingredient ingredient = ingredientOpt.get();

            // Créer l'association entre recette et ingrédient
            RecipeIngredient recipeIngredient = new RecipeIngredient(savedRecipe, ingredient, ingredientDTO.getQuantity());
            recipeIngredientRepository.save(recipeIngredient);
            recipeIngredients.add(recipeIngredient);
        }

        savedRecipe.setIngredients(recipeIngredients);
        return savedRecipe;
    }

    // Obtenir toutes les recettes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Obtenir une recette par ID
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    // Mettre à jour une recette existante
    public Recipe updateRecipe(Long id, RecipeDTO recipeDTO) {
        return null;
        /*return recipeRepository.findById(id).map(recipe -> {
            // Mettre à jour les champs de la recette
            recipe.setName(recipeDTO.getName());
            recipe.setCarbohydrates(recipeDTO.getCarbohydrates());
            recipe.setProteins(recipeDTO.getProteins());
            recipe.setLipids(recipeDTO.getLipids());
            recipe.setCalories(recipeDTO.getCalories());
            recipe.setInstructions(recipeDTO.getInstructions());

            // Supprimer les anciens RecipeIngredients associés à la recette
            recipeIngredientRepository.deleteAll(recipe.getRecipeIngredients());

            // Ajouter les nouveaux ingrédients
            for (IngredientDTO ingredientDTO : recipeDTO.getIngredients()) {
                Long ingredientId = ingredientDTO.getIngredientId();

                // Vérifier si l'ingrédient existe dans la base de données
                Optional<Ingredient> ingredientOpt = ingredientRepository.findById(ingredientId);
                if (ingredientOpt.isEmpty()) {
                    throw new RuntimeException("Ingredient not found with ID: " + ingredientId);
                }

                Ingredient ingredient = ingredientOpt.get();

                // Créer une nouvelle association entre recette et ingrédient
                RecipeIngredient newRecipeIngredient = new RecipeIngredient(recipe, ingredient, ingredientDTO.getQuantity());
                recipeIngredientRepository.save(newRecipeIngredient);
            }

            // Sauvegarder la recette mise à jour
            return recipeRepository.save(recipe);
        }).orElseThrow(() -> new RuntimeException("Recipe not found with ID: " + id));*/
    }


    // Supprimer une recette
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public RecipeResponse mapToRecipeResponse(Recipe recipe) {
        RecipeResponse response = new RecipeResponse();
        response.setId(recipe.getId());
        response.setName(recipe.getName());
        response.setCalories(recipe.getCalories());
        response.setProteins(recipe.getProteins());
        response.setCarbohydrates(recipe.getCarbohydrates());
        response.setLipids(recipe.getLipids());
        response.setInstructions(recipe.getInstructions());

        // Mapper les ingrédients en DTO simple
        List<IngredientQuantityDTO> ingredientQuantities = recipe.getIngredients().stream()
                .map(ri -> new IngredientQuantityDTO(
                        ri.getIngredient().getId(),
                        ri.getIngredient().getName(),
                        ri.getQuantity(),
                        ri.getIngredient().getStock(),
                        ri.getIngredient().getUnit().getSymbol()
                ))
                .collect(Collectors.toList());

        response.setIngredients(ingredientQuantities);

        return response;
    }

}
