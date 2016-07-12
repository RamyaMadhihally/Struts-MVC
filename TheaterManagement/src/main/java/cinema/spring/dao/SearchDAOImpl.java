package cinema.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cinema.spring.model.Movie;
import cinema.spring.model.SearchCriteria;

/**
 * An implementation of the MovieDAO interface.
 * 
 *
 */

public class SearchDAOImpl implements SearchDAO
{

	private JdbcTemplate jdbcTemplate;
	
	public SearchDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List<Movie> list(SearchCriteria search) {	
		
		String movieTitle = "%" + search.getMovie().getTitle().trim().toLowerCase() + "%";
		String genre      = "%" + search.getMovie().getGenre().trim().toLowerCase() + "%";
		int year          =  search.getMovie().getYear();
		
		String actor  = search.getActor().getName().trim().toLowerCase();
		String director  = search.getDirector().getName().trim().toLowerCase();
		String writer  = search.getWriter().getName().trim().toLowerCase();
		
		String sql = "select distinct m.movie_id, m.TITLE, m.genre, m.length, m.year, m.pgrating, m.posterurl from cs425movie m "+
					 "where lower(m.TITLE) like :title and lower(m.genre) like :genre ";					 
					
		if(!actor.equals(""))
		{
			actor = "%" + actor + "%";
			sql = sql + "and m.movie_id in (select movie_id from v_actor where lower(name) like '"+actor+"') ";
		}
		
		if(!director.equals(""))
		{
			director = "%" + director + "%";
			sql = sql + "and m.movie_id in (select movie_id from v_director where lower(name) like '"+director+"') ";
		}
		
		if(!writer.equals(""))
		{
			writer = "%" + writer + "%";
			sql = sql + "and m.movie_id in (select movie_id from v_writer where lower(name) like '"+writer+"') ";
		}
		
		if (year > 0)
		{
			sql = sql + "and m.year="+year;
		}
		
		System.out.println(sql);
		
		List<Movie> listMovie = jdbcTemplate.query(sql, new RowMapper<Movie>() {

			
			public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
				Movie movie = new Movie();
	
				movie.setId(rs.getInt("movie_id"));
				movie.setTitle(rs.getString("title"));
				movie.setGenre(rs.getString("genre"));
				movie.setLength(rs.getDouble("length"));
				movie.setYear(rs.getInt("year"));
				movie.setPgRating(rs.getString("pgrating"));
				movie.setPosterUrl(rs.getString("posterurl"));
				
				return movie;
			}
			
		},movieTitle, genre
		);
		
		return listMovie;
	}	
	
}