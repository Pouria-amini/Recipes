package recipes.business.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.persistence.UserRepository;

import javax.validation.constraints.Email;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        String newPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public User findUserByEmail(@Email String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean existsUserByEmail(@Email String email) {
        return userRepository.existsByEmail(email);
    }
}
