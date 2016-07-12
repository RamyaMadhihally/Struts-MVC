package cinema.spring.dao;

import cinema.spring.model.Writer;

public interface WriterDAO {

	public void saveOrUpdate(Writer writer);
	
	public void delete(int writerId, int movieId);
}
