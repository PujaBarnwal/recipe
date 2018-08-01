package com.example.recipe.services;

import com.example.recipe.model.Recipe;
import com.example.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RecipeServiceImplementation implements RecipeServiceInterface {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImplementation(RecipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }
    @Override
    public Set<Recipe> getRecipes() {
        log.debug("inside getRecipes method of RecipeServiceImplementation ");
        Set<Recipe> recipes = new HashSet<>();
        this.recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        //recipes.stream().map(i->i).collect(Collectors.toList());
        return recipes;

    }
}
