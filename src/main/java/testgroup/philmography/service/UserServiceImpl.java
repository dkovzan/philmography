package testgroup.philmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.philmography.dao.UserDao;
import testgroup.philmography.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	@Transactional
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	@Override
	@Transactional
	public void add(User user) {
		userDao.add(user);
	}
	
	@Override
	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}
	
	@Override
	@Transactional
	public void update(User user) {
		userDao.update(user);
	}
	
	@Override
	@Transactional
	public User getById(Long id) {
		return userDao.getById(id);
	}
}
