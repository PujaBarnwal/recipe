package com.example.recipe.Controller;

import com.example.recipe.model.Category;
import com.example.recipe.model.UnitOfMeasure;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import com.example.recipe.services.RecipeServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
public class IndexController {
    /*private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository*/;

    private final RecipeServiceInterface recipeServiceInterface;
   /* public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }*/

    public IndexController(RecipeServiceInterface recipeServiceInterface) {
        this.recipeServiceInterface = recipeServiceInterface;
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){
        log.debug("inside getIndex method of IndexController classes");
        /*Optional<Category> categoryOptional = this.categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = this.unitOfMeasureRepository.findByUom("Teaspoon");

        System.out.println("category id : "+categoryOptional.get().getId());
        System.out.println("UnitOfMeasure id : "+unitOfMeasureOptional.get().getId());
        System.out.println("input something to check after saving container started of its own or not");*/
        model.addAttribute("recipes", this.recipeServiceInterface.getRecipes());
        return "index";
    }
}
