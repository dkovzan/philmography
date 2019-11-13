package testgroup.philmography.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import testgroup.philmography.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return getSession().createQuery("from User").list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Optional<UserDetails> getByUsername(String username) {
		List<User> users = getSession().createQuery("from " + User.class.getName() + " where username = :value").setParameter("value", username).list();
		return users.isEmpty() ? Optional.empty() : Optional.of( users.get(0));
	}
	
	@Override
	public User getById(Long id) {
		return getSession().get(User.class, id);
	}
	
	@Override
	public void add(User user) {
		getSession().persist(user);
	}
	
	@Override
	public void update(User user) {
		getSession().update(user);
	}
	
	@Override
	public void delete(User user) {
		getSession().delete(user);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
