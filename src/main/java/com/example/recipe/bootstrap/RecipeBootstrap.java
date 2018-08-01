package com.example.recipe.bootstrap;

import com.example.recipe.model.*;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.RecipeRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public RecipeBootstrap(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("inside onApplicationEvent method of RecipeBootstrap classes");
        this.recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        log.debug("inside getRecipes method of RecipeBootstrap classes");

        List<Recipe> recipes = new ArrayList<>();
        System.out.println(recipes.size());
        Optional<UnitOfMeasure> teaSpoonOptional = this.unitOfMeasureRepository.findByUom("Teaspoon");
        if(!teaSpoonOptional.isPresent()){
            throw new RuntimeException("Exception teaSpoonOptional UOM is not found");
        }
        Optional<UnitOfMeasure> tablespoonOptional = this.unitOfMeasureRepository.findByUom("Tablespoon");
        if(!tablespoonOptional.isPresent()){
            throw new RuntimeException("Exception tablespoonOptional UOM is not found");
        }
        Optional<UnitOfMeasure> pinchOptional = this.unitOfMeasureRepository.findByUom("Pinch");
        if(!pinchOptional.isPresent()){
            throw new RuntimeException("Exception pinchOptional UOM is not found");
        }
        Optional<UnitOfMeasure> ounceOptional = this.unitOfMeasureRepository.findByUom("Ounce");
        if(!ounceOptional.isPresent()){
            throw new RuntimeException("Exception ounceOptional UOM is not found");
        }
        Optional<UnitOfMeasure> dashOptional = this.unitOfMeasureRepository.findByUom("Dash");
        if(!dashOptional.isPresent()){
            throw new RuntimeException("Exception dashOptional UOM is not found");
        }
        Optional<UnitOfMeasure> eachOptional = this.unitOfMeasureRepository.findByUom("Each");
        if(!eachOptional.isPresent()){
            throw new RuntimeException("Exception eachOptional UOM is not found");
        }
        Optional<UnitOfMeasure> pintOptional = this.unitOfMeasureRepository.findByUom("Pint");
        if(!pintOptional.isPresent()){
            throw new RuntimeException("Exception pintOptional UOM is not found");
        }
        Optional<Category> americanCategoryOptional = this.categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Exception americanCategoryOptional is not found");
        }
        Optional<Category> mexicanCategoryOptional = this.categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Exception mexicanCategoryOptional is not found");
        }
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.getCategories().add(americanCategoryOptional.get());
        guacamoleRecipe.getCategories().add(mexicanCategoryOptional.get());
        guacamoleRecipe.setCookTime(15);
        guacamoleRecipe.setDifficulty(Difficulty.MODERATE);
        guacamoleRecipe.setPrepTime(5);
        Notes guaNotes = new Notes();
        guaNotes.setNotes("Guacamole is so easy. All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.");
        //guaNotes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guaNotes);
        guacamoleRecipe.setDescription("1 Cut avocado, remove flesh"+"\n"+
        "2 Mash with a fork"+"\n"+
        "3 Add salt, lime juice, and the rest");
        /*guacamoleRecipe.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal(2),guacamoleRecipe,eachOptional.get() ));
        guacamoleRecipe.getIngredients().add(new Ingredient("Kosher salt",new BigDecimal(0.5),guacamoleRecipe,teaSpoonOptional.get() ));
        guacamoleRecipe.getIngredients().add(new Ingredient("resh lime juice or lemon juice",new BigDecimal(1),guacamoleRecipe,tablespoonOptional.get() ));*/
        guacamoleRecipe.setIngredient(new Ingredient("ripe avocados",new BigDecimal(2),eachOptional.get() ));
        guacamoleRecipe.setIngredient(new Ingredient("Kosher salt",new BigDecimal(0.5),teaSpoonOptional.get() ));
        guacamoleRecipe.setIngredient(new Ingredient("resh lime juice or lemon juice",new BigDecimal(1),tablespoonOptional.get() ));
        recipes.add(guacamoleRecipe);
        Recipe pannerTikkaRecipe = new Recipe();
        pannerTikkaRecipe.getCategories().add(americanCategoryOptional.get());
        pannerTikkaRecipe.getCategories().add(mexicanCategoryOptional.get());
        pannerTikkaRecipe.setCookTime(20);
        pannerTikkaRecipe.setDifficulty(Difficulty.MODERATE);
        pannerTikkaRecipe.setPrepTime(10);
        Notes pannerNotes = new Notes();
        pannerNotes.setNotes("paneerTikka is so easy. All you really need to make pannertikka is good and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.");
        pannerNotes.setRecipe(pannerTikkaRecipe);
        pannerTikkaRecipe.setNotes(pannerNotes);
        pannerTikkaRecipe.setDescription("1 Cut paneer, remove flesh"+"\n"+
                "2 Mash with a fork"+"\n"+
                "3 Add salt, lime juice, and the rest");
        pannerTikkaRecipe.setIngredient(new Ingredient("Fried paneer",new BigDecimal(3),eachOptional.get() ));
        pannerTikkaRecipe.setIngredient(new Ingredient("Kosher salt and chopped onion",new BigDecimal(0.5),teaSpoonOptional.get() ));
        pannerTikkaRecipe.setIngredient(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(1),tablespoonOptional.get() ));
        pannerTikkaRecipe.setIngredient(new Ingredient("chopped green veggies",new BigDecimal(2),tablespoonOptional.get() ));
        recipes.add(pannerTikkaRecipe);
        return recipes;
        }
}
