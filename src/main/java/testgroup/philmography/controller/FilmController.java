package testgroup.philmography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import testgroup.philmography.model.Film;
import testgroup.philmography.service.FilmService;

import java.util.List;

@RestController
public class FilmController {

	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping(value = "/films")
	public List<Film> allFilms() {
		List<Film> filmsList = filmService.getAll();
		return filmsList;
	}

	@GetMapping(value = "/film/{id}")
	public Film editFilm(@PathVariable("id") int id) {
		Film film = filmService.getById(id);
		if(film == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Entity is not found"
			);
		}
		return film;
	}

	@PutMapping(value = "/film")
	public void editFilm(@RequestBody Film film) {
		filmService.update(film);
	}

	@PostMapping(value = "/film")
	public void addFilm(@RequestBody Film film) {
		filmService.add(film);
	}

	@DeleteMapping(value = "/film/{id}")
	public void removeFilm(@PathVariable("id") int id) {
		Film film = filmService.getById(id);
		filmService.delete(film);
	}
}
