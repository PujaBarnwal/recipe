package com.example.recipe.services;

import com.example.recipe.model.Recipe;
import com.example.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplementationTest {
    RecipeServiceImplementation recipeServiceImplementation;
    @Mock
    RecipeRepository mockRecipeRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeServiceImplementation = new RecipeServiceImplementation(mockRecipeRepository);

    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        when(recipeServiceImplementation.getRecipes()).thenReturn(recipeData);
        Set<Recipe> recipes = recipeServiceImplementation.getRecipes();
        assertEquals(recipes.size(),1);
        verify(mockRecipeRepository,times(1)).findAll();
    }
}