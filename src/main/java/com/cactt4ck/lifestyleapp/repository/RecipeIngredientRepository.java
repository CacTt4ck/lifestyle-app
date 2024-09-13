package com.cactt4ck.lifestyleapp.repository;

import com.cactt4ck.lifestyleapp.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}