package recipes.business.recipes;

import lombok.Data;

@Data
public class RecipeFrame {

    private String name;
    private String category;
    private String date;
    private String description;
    private String[] ingredients;
    private String[] directions;

    public RecipeFrame(Recipe recipe) {
        this.name = recipe.getName();
        this.category = recipe.getCategory();
        this.date = recipe.getDate();
        this.description = recipe.getDescription();
        this.ingredients = stringToArray(recipe.getIngredients());
        this.directions = stringToArray(recipe.getDirections());
    }

    public String[] stringToArray(String str) {
        return str.substring(1, str.length()-1).split("\\^\\|\\^, ");
    }
}
