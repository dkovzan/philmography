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
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Optional<UserDetails> getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from " + User.class.getName() + " where username = :value").setParameter("value", username).list();
		return users.isEmpty() ? Optional.empty() : Optional.of( users.get(0));
	}
	
	@Override
	public User getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}
	
	@Override
	public void add(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}
	
	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}
	
	@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}
}
