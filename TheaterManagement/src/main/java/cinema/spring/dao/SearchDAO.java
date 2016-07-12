package cinema.spring.dao;

import java.util.List;

import cinema.spring.model.Movie;
import cinema.spring.model.SearchCriteria;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */

public interface SearchDAO {
	
	public List<Movie> list(SearchCriteria searchCriteria);
	
}
