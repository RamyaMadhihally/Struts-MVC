package cinema.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cinema.spring.model.Actor;
import cinema.spring.model.Director;
import cinema.spring.model.Movie;
import cinema.spring.model.Writer;

/**
 * An implementation of the MovieDAO interface.
 * 
 *
 */
public class MovieDAOImpl implements MovieDAO {

	private JdbcTemplate jdbcTemplate;
	
	public MovieDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public void saveOrUpdate(Movie movie) {
		if (movie.getId() > 0) {
			
			// update
			String sql = "UPDATE cs425Movie "
					   + "SET title=?, genre=?, length=?, "
					   + "year=?, pgRating=?, posterUrl=? "
					   + "WHERE movie_id=?";
			
			jdbcTemplate.update(sql, movie.getTitle(), movie.getGenre(), movie.getLength(), movie.getYear(), movie.getPgRating(), movie.getPosterUrl(), movie.getId());
			
		} else {
			// insert
			String sql = "INSERT INTO cs425Movie (title, genre, length, year, pgrating, posterurl)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, movie.getTitle(), movie.getGenre(), movie.getLength(), movie.getYear(), movie.getPgRating(), movie.getPosterUrl());
		}
		
	}

	
	public void delete(int movieId) {
		String sql = "DELETE FROM cs425Movie WHERE movie_id=?";
		jdbcTemplate.update(sql, movieId);
	}

	
	public List<Movie> list() {
		String sql = "SELECT * FROM cs425Movie";
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
			
		});
		
		return listMovie;
	}

	
	public Movie get(int movieId) {
		String sql = "SELECT * FROM cs425Movie WHERE movie_id=" + movieId;
		return jdbcTemplate.query(sql, new ResultSetExtractor< Movie>() {

			
			public Movie extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
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
				
				return null;
			}
			
		});
	}

	
	public List<Actor> listActors(int movieId) {
		String sql = "SELECT a.movie_id,p.person_id, p.name, p.imageurl, a.rolename,p.birthdate FROM cs425Person p, cs425Actor a where a.actor_id=p.person_id and a.movie_id=?";
		List<Actor> listActors = jdbcTemplate.query(sql, new RowMapper<Actor>() {

			
			public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Actor actor = new Actor();	
				actor.setMovieid(rs.getInt("movie_id"));
				actor.setActorid(rs.getInt("person_id"));
				actor.setName(rs.getString("name"));
				actor.setRoleName(rs.getString("rolename"));
				actor.setBirthDate(rs.getString("birthDate"));
				actor.setImageUrl(rs.getString("imageurl"));
				
				return actor;
			}
			
		},movieId);
		
		return listActors;
	}

	
	public List<Director> listDirectors(int movieId) {
		String sql = "SELECT d.movie_id,p.person_id, p.name, p.imageurl,p.birthdate FROM cs425Person p, cs425Director d where d.director_id=p.person_id and d.movie_id=?";
		List<Director> listDirectors = jdbcTemplate.query(sql, new RowMapper<Director>() {

			
			public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
				Director director = new Director();	
				director.setMovieid(rs.getInt("movie_id"));
				director.setDirectorid(rs.getInt("person_id"));
				director.setName(rs.getString("name"));
				director.setImageUrl(rs.getString("imageurl"));
				director.setBirthDate(rs.getString("birthDate"));
				
				return director;
			}
			
		},movieId);
		
		return listDirectors;
	}
	
	
	public List<Writer> listWriters(int movieId) {
		String sql = "SELECT w.movie_id,p.person_id, p.name, p.imageurl,p.birthdate FROM cs425Person p, cs425Writer w where w.writer_id=p.person_id and w.movie_id=?";
		List<Writer> listWriters = jdbcTemplate.query(sql, new RowMapper<Writer>() {

			
			public Writer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Writer writer = new Writer();	
				writer.setMovieid(rs.getInt("movie_id"));
				writer.setWriterid(rs.getInt("person_id"));
				writer.setName(rs.getString("name"));
				writer.setImageUrl(rs.getString("imageurl"));
				writer.setBirthDate(rs.getString("birthDate"));
				
				return writer;
			}
			
		},movieId);
		
		return listWriters;
	}

}
