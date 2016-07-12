package cinema.spring.dao;

import cinema.spring.model.Actor;

public interface ActorDAO {

	public void saveOrUpdate(Actor actor);
	
	public void delete(int actorId, int movieId);
	
}
