package cinema.spring.dao;

import cinema.spring.model.Director;

public interface DirectorDAO {

	public void saveOrUpdate(Director director);
	
	public void delete(int directorId, int movieId);

}
