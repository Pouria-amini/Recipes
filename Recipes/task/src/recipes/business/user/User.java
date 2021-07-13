package recipes.business.user;

import recipes.business.recipes.Recipe;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Email
    @Pattern(regexp=".*@.*\\..*")
    @NotBlank
    @Column(name = "email")
    private String email;

    @Size(min = 8)
    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String roles = "USER";

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy="user")
    private List<Recipe> recipes = new ArrayList<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
