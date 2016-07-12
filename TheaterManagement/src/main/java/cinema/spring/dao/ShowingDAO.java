package cinema.spring.dao;

import java.util.List;

import cinema.spring.model.Showing;
import cinema.spring.model.Ticket;

public interface ShowingDAO {
	
	public List<Showing> list();
	
	public Showing get(int showId);
	
	public void delete(int showId);
	
	public void saveOrUpdate(Showing showing);
	
	public List<Showing> listShowingsForMovie(int movieId);
	
	public String bookTickets(List<Ticket> tickets);

}
