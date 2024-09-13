package com.cactt4ck.lifestyleapp.repository;

import com.cactt4ck.lifestyleapp.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
