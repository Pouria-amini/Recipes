package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.business.recipes.ID;
import recipes.business.recipes.Recipe;
import recipes.business.recipes.RecipeFrame;
import recipes.business.recipes.RecipeService;
import recipes.business.user.User;
import recipes.business.user.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    private static Long counter = 0L;

    @Autowired
    RecipeService recipeService;

    @Autowired
    UserService userService;


    @PostMapping("/api/recipe/new")
    public ID setRecipe(@Valid @RequestBody Recipe recipe,
                        @AuthenticationPrincipal UserDetails currentUser) {

        User user = userService.findUserByEmail(currentUser.getUsername());
        Recipe newRecipe = new Recipe(
                ++counter,
                recipe.getName(),
                recipe.getCategory(),
                LocalDateTime.now(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections(),
                user
        );

        Recipe receivedRecipe = recipeService.save(newRecipe);
        user.getRecipes().add(receivedRecipe);

        return new ID(counter);
    }


    @GetMapping("/api/recipe/{id}")
    public RecipeFrame getRecipe(@PathVariable long id) {

        if (recipeService.notExistsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");

        return new RecipeFrame(recipeService.findRecipeById(id));
    }


    @DeleteMapping("/api/recipe/{id}")
    public void removeRecipe(@PathVariable long id,
                             @AuthenticationPrincipal UserDetails currentUser) {

        User user = userService.findUserByEmail(currentUser.getUsername());

        if (recipeService.notExistsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        else if (!recipeService.findRecipeById(id).getUser().getEmail().equals(user.getEmail()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");

        recipeService.deleteById(id);

        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Content");
    }

    @PutMapping("/api/recipe/{id}")
    public void updateRecipe(@PathVariable long id,
                             @Valid @RequestBody Recipe recipe,
                             @AuthenticationPrincipal UserDetails currentUser) {

        User user = userService.findUserByEmail(currentUser.getUsername());

        if (recipeService.notExistsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        else if (!recipeService.findRecipeById(id).getUser().getEmail().equals(user.getEmail()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden");

        Recipe newRecipe = new Recipe(
                id,
                recipe.getName(),
                recipe.getCategory(),
                LocalDateTime.now(),
                recipe.getDescription(),
                recipe.getIngredients(),
                recipe.getDirections(),
                user
        );

        Recipe receivedRecipe = recipeService.save(newRecipe);
        user.getRecipes().add(receivedRecipe);

        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Content");
    }

    @GetMapping("/api/recipe/search")
    public List<RecipeFrame> getRecipes(@RequestParam Map<String, String> params) {

        if (params.size() != 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        } else if (!params.getOrDefault("name", "").equals("")) {
            return recipeService.findAllByNameOrderByDate(params.get("name"));
        } else if (!params.getOrDefault("category", "").equals("")) {
            return recipeService.findAllByCategoryOrderByDate(params.get("category"));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
    }
}
