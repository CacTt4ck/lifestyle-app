package com.cactt4ck.lifestyleapp.controller;

import com.cactt4ck.lifestyleapp.model.Recipe;
import com.cactt4ck.lifestyleapp.model.RecipeResponse;
import com.cactt4ck.lifestyleapp.model.dto.IngredientDTO;
import com.cactt4ck.lifestyleapp.model.dto.RecipeDTO;
import com.cactt4ck.lifestyleapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeResponse> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe newRecipe = Recipe.builder()
                .name(recipeDTO.getName())
                .calories(recipeDTO.getCalories())
                .carbohydrates(recipeDTO.getCarbohydrates())
                .proteins(recipeDTO.getProteins())
                .lipids(recipeDTO.getLipids())
                .instructions(recipeDTO.getInstructions())
                .build();

        List<IngredientDTO> ingredientDTOs = recipeDTO.getIngredients();

        Recipe savedRecipe = recipeService.addRecipe(newRecipe, ingredientDTOs);
        RecipeResponse response = recipeService.mapToRecipeResponse(savedRecipe);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public List<RecipeResponse> getAllRecipes() {
        List<RecipeResponse> recipeResponses = new ArrayList<>();
        recipeService.getAllRecipes().forEach(recipe -> recipeResponses.add(recipeService.mapToRecipeResponse(recipe)));
        return recipeResponses;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(value -> ResponseEntity.ok(recipeService.mapToRecipeResponse(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDTO);
        return ResponseEntity.ok(updatedRecipe);
    }

    @PutMapping("/id/image")
    public ResponseEntity<Recipe> updateRecipeImage(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}

