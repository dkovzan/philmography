package testgroup.philmography.dao;

import testgroup.philmography.model.Film;

import java.util.List;

public interface FilmDao {
	List<Film> getAll();
	void add(Film film);
	void delete(Film film);
	void update(Film film);
	Film getById(int id);
}
