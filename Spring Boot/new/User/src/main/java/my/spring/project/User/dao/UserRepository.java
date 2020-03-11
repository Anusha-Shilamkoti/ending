package my.spring.project.User.dao;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.User.pojos.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
User findByUserNameAndPassword(String userName, String password);

User findByUserNameAndPasswordAndConfirmed(String username, String password, String string);

Optional<User> findByEmail(String emailId);
}
