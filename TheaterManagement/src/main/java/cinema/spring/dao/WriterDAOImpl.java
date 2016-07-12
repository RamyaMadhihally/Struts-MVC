package cinema.spring.dao;


import java.math.BigDecimal;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cinema.spring.model.Writer;

public class WriterDAOImpl implements WriterDAO{

	private JdbcTemplate jdbcTemplate;
	
	public WriterDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public void saveOrUpdate(Writer writer) {

		String sql = null;
		BigDecimal personId = getPersonId(writer.getName());		
		if(personId == null)
		{
			
			sql = "INSERT INTO cs425Person (name, imageurl, gender, birthdate)"
					+ " VALUES (?,?,?,TO_DATE(?,'dd/mon/yyyy'))";
			jdbcTemplate.update(sql, writer.getName(), writer.getImageUrl(), writer.getgender(),writer.getBirthDate());
		    
			
			
		}
		
		sql = "INSERT INTO cs425Writer (writer_id, movie_id)"
				+ " VALUES (?, ?)";
		
		jdbcTemplate.update(sql, getPersonId(writer.getName()), writer.getMovieid());	
		
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

	
	public void delete(int writerId, int movieId) {
		String sql = "DELETE FROM cs425Writer WHERE writer_id=? and movie_id=?";
		jdbcTemplate.update(sql, writerId, movieId);
		
	}
	
		

	}
