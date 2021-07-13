package recipes.business.recipes;

import recipes.business.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @NotNull
    private long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private String date;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotBlank
    @Pattern(regexp = "\\[.+]")
    @Column(name = "ingredients")
    private String ingredients;

    @NotBlank
    @Pattern(regexp = "\\[.+]")
    @Column(name = "directions")
    private String directions;

    @ManyToOne
    private User user;

    public Recipe(long id, String name,
                  String category,
                  LocalDateTime date,
                  String description,
                  String ingredients,
                  String directions,
                  User user
    ) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.date = date.toString();
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.user = user;
    }

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        for(int i = 0; i < ingredients.length-1; i++) {
            ingredients[i] = ingredients[i] + "^|^";
        }
        this.ingredients = Arrays.toString(ingredients);
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
        for(int i = 0; i < directions.length-1; i++) {
            directions[i] = directions[i] + "^|^";
        }
        this.directions = Arrays.toString(directions);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", directions='" + directions + '\'' +
                ", user=" + user.getEmail() +
                '}';
    }
}
