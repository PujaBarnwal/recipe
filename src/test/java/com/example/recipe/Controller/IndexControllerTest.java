package com.example.recipe.Controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.services.RecipeServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.injection.MockInjection;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {
    IndexController indexController;
    @Mock
    RecipeServiceInterface recipeServiceInterface;
    @Mock
    Model model;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeServiceInterface);
    }
    @Test
    public void mockMvcTest() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("index"));


    }

    @Test
    public void getIndex() throws Exception{
        //given
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setId(4l);
        recipeSet.add(recipe);
        when(recipeServiceInterface.getRecipes()).thenReturn(recipeSet);
        ArgumentCaptor<Set<Recipe>> argumentCaptor= ArgumentCaptor.forClass(Set.class);
        //when
        String expectedString = indexController.getIndex(model);
        //then
        assertEquals("index",expectedString);
        verify(recipeServiceInterface,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());

    }
}