package recipes.business.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.persistence.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe findRecipeById(Long id) {
        return recipeRepository.findRecipeById(id);
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe save(Recipe toSave) {
        return recipeRepository.save(toSave);
    }

    public boolean notExistsById(Long id) {
        return !recipeRepository.existsById(id);
    }

    public List<RecipeFrame> findAllByNameOrderByDate(String name) {
        List<Recipe> list =  recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
        List<RecipeFrame> listFrame = new ArrayList<>();
        for(Recipe i: list) {
            listFrame.add(new RecipeFrame(i));
        }
        return listFrame;
    }

    public List<RecipeFrame> findAllByCategoryOrderByDate(String category) {
        List<Recipe> list =  recipeRepository.findAllByCategoryIgnoreCaseEqualsOrderByDateDesc(category);
        List<RecipeFrame> listFrame = new ArrayList<>();
        for(Recipe i: list) {
            listFrame.add(new RecipeFrame(i));
        }
        return listFrame;
    }
}
