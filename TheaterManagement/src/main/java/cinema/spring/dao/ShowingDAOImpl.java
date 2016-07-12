package cinema.spring.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;





import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cinema.spring.model.CustomMapper;
import cinema.spring.model.Movie;
import cinema.spring.model.Showing;
import cinema.spring.model.Ticket;

public class ShowingDAOImpl implements ShowingDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ShowingDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void saveOrUpdate(Showing showing) {
		
		BigDecimal movie_id =jdbcTemplate.queryForObject("select movie_id from cs425movie where lower(title)='"+showing.getTitle().trim().toLowerCase()+"'", BigDecimal.class);
		
			// update
		if (showing.getshowid () > 0) {
			String sql = "UPDATE cs425Showing "
					   + "SET room_Number=?, available_Seats=?, startTime=?, "
					   + " price=? "
					   + "WHERE movie_id=? and showid=?" ;
			jdbcTemplate.update(sql, showing.getroomNumber(),showing.getavailableSeats(),showing.getstartTime(),showing.getprice(),movie_id,showing.getshowid());
		}else {
			// insert
			String sql = "INSERT INTO cs425Showing (movie_id, room_Number, available_Seats, startTime,  price)"
						+ " VALUES ( ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql,movie_id, showing.getroomNumber(), showing.getavailableSeats(), showing.getstartTime(),  showing.getprice());
	}
		
	}

	
	public List<Showing> list() {
		List<Showing> listShowing = null;
		try
		{
		String sql = "select title,showid,MOVIE_ID,room_number,available_Seats,startTime,price FROM cs425Showing NATURAL JOIN cs425Movie";
		
		listShowing = jdbcTemplate.query(sql, new RowMapper<Showing>() {

			
			public Showing mapRow(ResultSet rs, int rowNum) throws SQLException {
				Showing showing = new Showing();
				showing.setshowid(rs.getInt("showid"));
				showing.setMovieId(rs.getInt("movie_id"));
				showing.setroomNumber(rs.getString("room_Number"));
				showing.setavailableSeats(rs.getInt("available_Seats"));
				showing.setstartTime(rs.getTimestamp("startTime"));
				showing.setprice(rs.getDouble("price"));
				showing.setTitle(rs.getString("title"));

				return showing;
			}
			
		});
		
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return listShowing;
	}
	

	
	public Showing get(int showId) {
		String sql = "SELECT s.showid, s.movie_id, s.room_Number, s.available_Seats, s.startTime, s.price, m.title FROM cs425Showing s, Movie m WHERE s.movie_id=m.movie_id AND s.showid =" + showId;
		return jdbcTemplate.query(sql, new ResultSetExtractor< Showing>() {

			
			public Showing extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Showing showing = new Showing();
					showing.setshowid((rs.getInt("showid")));
					showing.setMovieId((rs.getInt("movie_id")));
					showing.setroomNumber(rs.getString("room_Number"));
					showing.setavailableSeats(rs.getInt("available_Seats"));
					showing.setstartTime(rs.getTimestamp("startTime"));
					showing.setprice(rs.getDouble("price"));
					showing.setTitle(rs.getString("title"));
					
	
					return showing;
				}
				
				return null;
			}
			
		});
		
		
	}
	
	
	
	
	
	public void delete(int showId) {
		String sql = "DELETE FROM cs425Showing WHERE showid=?";
		jdbcTemplate.update(sql, showId);
		
	}

	
	public List <Showing> listShowingsForMovie(int movieId)
	{
		String sql = "select m.title,s.movie_id,s.showid,s.available_seats,s.startTime,s.price from cs425showing s, cs425movie m where s.movie_id=m.movie_id AND s.MOVIE_ID=?";
		List<Showing> listBooking = jdbcTemplate.query(sql, new RowMapper<Showing>() {

			
			public Showing mapRow(ResultSet rs, int rowNum) throws SQLException {
				Showing showing = new Showing();
				showing.setTitle(rs.getString("title"));
				showing.setMovieId(rs.getInt("movie_id"));
				showing.setshowid(rs.getInt("showid"));
				showing.setavailableSeats(rs.getInt("available_seats"));
				showing.setstartTime(rs.getTimestamp("startTime"));
				showing.setprice(rs.getDouble("price"));
				return showing;
			}
						
		},movieId);
		
		return listBooking;
	}

	
	public String bookTickets(List<Ticket> tickets) {
	
		String confirmatonNumber = "CMS"+String.valueOf(System.currentTimeMillis()).hashCode();
		
		String room=null;
		Date startTime=null;
				
		for(Ticket ticket : tickets)
		{
					String sql = "INSERT INTO cs425Booking (paymentreg_id, room_Number, startTime,confirmation)"
								+ " VALUES ( ?, ?, ?,?)";
					
					jdbcTemplate.update(sql,ticket.getPaymentRegistratonId(), ticket.getRoomNumber(), ticket.getStartTime(), confirmatonNumber);
					
					room = ticket.getRoomNumber();
					startTime= ticket.getStartTime();		

		}
		
		String updateAvailability = "UPDATE cs425Showing "
				   + "SET available_Seats=available_Seats-?"
				   + " WHERE room_number=? and starttime=?" ;
		jdbcTemplate.update(updateAvailability, tickets.size(),room,startTime);
		
		return confirmatonNumber;
		
	}
}
