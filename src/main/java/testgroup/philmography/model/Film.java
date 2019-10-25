package testgroup.philmography.model;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {

	public Film() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private Integer year;
	
	private String genre;
	
	private boolean watched;

	public Film(Long id, String title, Integer year, String genre, boolean watched) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.watched = watched;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isWatched() {
		return watched;
	}

	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	@Override
	public String toString() {
		return "Film{" +
				"id=" + id +
				", title='" + title + '\'' +
				", year=" + year +
				", genre='" + genre + '\'' +
				", watched=" + watched +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Film film = (Film) o;
		
		if (isWatched() != film.isWatched()) return false;
		if (!getId().equals(film.getId())) return false;
		if (!getTitle().equals(film.getTitle())) return false;
		if (getYear() != null ? !getYear().equals(film.getYear()) : film.getYear() != null) return false;
		return getGenre() != null ? getGenre().equals(film.getGenre()) : film.getGenre() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getTitle().hashCode();
		result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
		result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
		result = 31 * result + (isWatched() ? 1 : 0);
		return result;
	}
}
