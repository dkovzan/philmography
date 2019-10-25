package testgroup.philmography.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.philmography.model.Film;

import java.util.List;

@Repository
public class FilmDaoImpl implements FilmDao {

	private SessionFactory sessionFactory;

	@Autowired
	public FilmDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Film> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Film").list();
	}

	@Override
	public void add(Film film) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(film);
	}

	@Override
	public void delete(Film film) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(film);
	}

	@Override
	public void update(Film film) {
		Session session = sessionFactory.getCurrentSession();
		session.update(film);
	}

	@Override
	public Film getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Film.class, id);
	}
}
