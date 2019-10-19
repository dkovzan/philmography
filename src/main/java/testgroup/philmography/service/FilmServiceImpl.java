package testgroup.philmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.philmography.dao.FilmDao;
import testgroup.philmography.model.Film;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

	private FilmDao filmDao;

	@Autowired
	public FilmServiceImpl(FilmDao filmDao) {
		this.filmDao = filmDao;
	}

	@Override
	@Transactional
	public List<Film> getAll() {
		return filmDao.getAll();
	}

	@Override
	@Transactional
	public void add(Film film) {
		filmDao.add(film);
	}

	@Override
	@Transactional
	public void delete(Film film) {
		filmDao.delete(film);
	}

	@Override
	@Transactional
	public void update(Film film) {
		filmDao.update(film);
	}

	@Override
	@Transactional
	public Film getById(int id) {
		return filmDao.getById(id);
	}
}
