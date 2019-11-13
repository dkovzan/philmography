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
		return getSession().createQuery("from Film").list();
	}

	@Override
	public void add(Film film) {
		getSession().persist(film);
	}

	@Override
	public void delete(Film film) {
		getSession().delete(film);
	}

	@Override
	public void update(Film film) {
		getSession().update(film);
	}

	@Override
	public Film getById(Long id) {
		return getSession().get(Film.class, id);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
