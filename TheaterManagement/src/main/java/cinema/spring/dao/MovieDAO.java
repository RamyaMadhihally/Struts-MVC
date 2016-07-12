package cinema.spring.dao;

import java.util.List;

import cinema.spring.model.Actor;
import cinema.spring.model.Director;
import cinema.spring.model.Movie;
import cinema.spring.model.Writer;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface MovieDAO {
	
	public void saveOrUpdate(Movie movie);
	
	public void delete(int movieId);
	
	public Movie get(int movieId);
	
	public List<Movie> list();
	
	public List<Actor> listActors(int movieId);
	
	public List<Director> listDirectors(int movieId);
	
	public List<Writer> listWriters(int movieId);
}
