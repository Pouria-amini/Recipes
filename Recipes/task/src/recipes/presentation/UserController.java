package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.business.user.User;
import recipes.business.user.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void getUser(@Valid @RequestBody User user) {
        if (userService.existsUserByEmail(user.getEmail()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");

        userService.save(user);
    }
}
