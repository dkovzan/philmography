package testgroup.philmography.service;

import testgroup.philmography.model.Film;

import java.util.List;

public interface FilmService {
	List<Film> getAll();
	void add(Film film);
	void delete(Film film);
	void update(Film film);
	Film getById(int id);
}
