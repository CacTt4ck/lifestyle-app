package com.cactt4ck.lifestyleapp.repository;

import com.cactt4ck.lifestyleapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
