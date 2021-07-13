package recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.business.user.User;

import javax.validation.constraints.Email;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmail(@Email String email);

    boolean existsByEmail(@Email String email);

}
