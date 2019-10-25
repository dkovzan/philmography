package testgroup.philmography.dao;

import org.springframework.security.core.userdetails.UserDetails;
import testgroup.philmography.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
	
	List<User> getAll();
	Optional<UserDetails> getByUsername(String username);
	User getById(Long id);
	void add(User user);
	void update(User user);
	void delete(User user);
	
}
