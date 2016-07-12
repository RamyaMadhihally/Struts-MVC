package cinema.spring.dao;


import java.math.BigDecimal;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cinema.spring.model.Actor;

public class ActorDAOImpl implements ActorDAO{

	private JdbcTemplate jdbcTemplate;
	
	public ActorDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveOrUpdate(Actor actor) {

		String sql = null;
		BigDecimal personId = getPersonId(actor.getName());		
		if(personId == null)
		{
			sql = "INSERT INTO cs425Person (name, imageurl, gender, birthdate)"
					+ " VALUES (?,?,?,TO_DATE(?,'dd/mon/yyyy'))";
			
			//System.out.println(sql +","+ actor.getName()+","+ actor.getImageUrl()+","+ actor.getgender());
			
			jdbcTemplate.update(sql, actor.getName(), actor.getImageUrl(), actor.getgender(),actor.getBirthDate());
		    
		}
		
		sql = "INSERT INTO cs425Actor (actor_id, movie_id, rolename)"
				+ " VALUES (?, ?, ?)";
		System.out.println(sql +": "+ getPersonId(actor.getName()) +", "+ actor.getMovieid() + ", "+actor.getRoleName());
		jdbcTemplate.update(sql, getPersonId(actor.getName()), actor.getMovieid(),actor.getRoleName());	
		
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

	public void delete(int actorId, int movieId) {
		String sql = "DELETE FROM cs425Actor WHERE actor_id=? and movie_id=?";
		jdbcTemplate.update(sql, actorId, movieId);
		
	}
	}
