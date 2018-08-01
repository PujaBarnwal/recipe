package com.example.recipe.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CategoryTest {
    Category category;
    @Before
    public void setUp(){
        category = new Category();}

    @Test
    public void getId() {
        Long id = 4l;
        category.setId(id);
        assertEquals(category.getId(),id);
    }

    @Test
    public void getDescription() {
        String actualDecription = "this a test description";
        category.setDescription(actualDecription);
        assertEquals(category.getDescription(),actualDecription);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        category.setRecipes(recipeData);
        assertEquals(category.getRecipes(),recipeData);
    }
}