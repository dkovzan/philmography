package testgroup.philmography.service;

import testgroup.philmography.model.User;

import java.util.List;

public interface UserService {
	
	List<User> getAll();
	void add(User user);
	void delete(User user);
	void update(User user);
	User getById(Long id);
}
