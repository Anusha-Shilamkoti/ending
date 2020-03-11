package my.spring.project.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.pojos.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
User findByUserNameAndPassword(String userName, String password);

User findByUserNameAndPasswordAndConfirmed(String username, String password, String string);

Optional<User> findByEmail(String emailId);
}
