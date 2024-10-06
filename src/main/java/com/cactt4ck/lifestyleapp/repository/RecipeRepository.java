package com.cactt4ck.lifestyleapp.repository;

import com.cactt4ck.lifestyleapp.model.Image;
import com.cactt4ck.lifestyleapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Modifying
    @Query("update Recipe r set r.image = :uri where r.id = :id")
    void addImage(@Param("id") Long recipeId, @Param("uri") String imageURI);
}
