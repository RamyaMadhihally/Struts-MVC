package cinema.spring.dao;
import java.math.BigDecimal;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cinema.spring.model.Director;


public class DirectorDAOImpl implements DirectorDAO{

	private JdbcTemplate jdbcTemplate;
	
	public DirectorDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public void saveOrUpdate(Director director) {

		String sql = null;
		BigDecimal personId = getPersonId(director.getName());		
		if(personId == null)
		{
			sql = "INSERT INTO cs425Person (name, imageurl, gender, birthdate)"
					+ " VALUES (?,?,?,TO_DATE(?,'dd/mon/yyyy'))";
			jdbcTemplate.update(sql, director.getName(), director.getImageUrl(),director.getgender(),director.getBirthDate());
		    
		}
		
		sql = "INSERT INTO cs425Director (director_id, movie_id)"
				+ " VALUES (?, ?)";
		System.out.println(sql +": "+ getPersonId(director.getName()) +", "+ director.getMovieid());
		jdbcTemplate.update(sql, getPersonId(director.getName()), director.getMovieid());	
		
	}	
	
	
	private BigDecimal getPersonId(String name) 
	{
		BigDecimal personId = null;
		Map<String, Object> person = null;
		String sql = "SELECT * FROM cs425Person WHERE name=?";
		
		try
		{
			person = jdbcTemplate.queryForMap(sql,name);
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		if( person.get("PERSON_ID") != null)
		{
			personId=  (BigDecimal) person.get("PERSON_ID");
		}
		return personId;
	}

	
	public void delete(int directorId, int movieId) {
		String sql = "DELETE FROM cs425Director WHERE director_id=? and movie_id=?";
		jdbcTemplate.update(sql, directorId, movieId);
		
	}
	}
