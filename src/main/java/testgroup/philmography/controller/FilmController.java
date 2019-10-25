package testgroup.philmography.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import testgroup.philmography.model.Film;
import testgroup.philmography.service.FilmService;

import java.util.List;

@RestController
@Api(value = "Films REST Endpoint", description = "Manages operations with films")
public class FilmController {

	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@ApiOperation("Get all films")
	@GetMapping(value = "/api/films")
	public List<Film> allFilms() {
		List<Film> filmsList = filmService.getAll();
		return filmsList;
	}

	@ApiOperation("Get film by id")
	@GetMapping(value = "/api/film/{id}")
	public Film editFilm(@PathVariable("id") Long id) {
		Film film = filmService.getById(id);
		if(film == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Entity is not found"
			);
		}
		return film;
	}
	
	@ApiOperation("Update film")
	@PutMapping(value = "/api/film")
	public void editFilm(@RequestBody Film film) {
		filmService.update(film);
	}
	
	@ApiOperation("Add new film")
	@PostMapping(value = "/api/film")
	public void addFilm(@RequestBody Film film) {
		filmService.add(film);
	}
	
	@ApiOperation("Remove film by id")
	@DeleteMapping(value = "/api/film/{id}")
	public void removeFilm(@PathVariable("id") Long id) {
		Film film = filmService.getById(id);
		filmService.delete(film);
	}
}
