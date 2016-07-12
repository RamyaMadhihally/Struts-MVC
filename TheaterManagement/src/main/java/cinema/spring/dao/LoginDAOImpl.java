package cinema.spring.dao;


import cinema.spring.config.Constants;
import cinema.spring.model.LoginException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import cinema.spring.model.CustomMapper;


public class LoginDAOImpl implements LoginDAO {
private JdbcTemplate jdbcTemplate;
	
	public LoginDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@SuppressWarnings("unchecked")
	
	public CustomMapper validateUser(String userName,String password) throws LoginException {

		CustomMapper login=null;
		String sql="select * from cs425users where username = ?";
		
		try
		{
			login=jdbcTemplate.queryForObject(sql,new Object[] {userName},new CustomMapper());
		}
		catch(EmptyResultDataAccessException e){
			throw new LoginException("Invalid Username");
		}
		
		if((login.getPassword().equals(password)) == false)
		{
		throw new LoginException("Invalid Password");
		}
		
		sql="Select count(*) from cs425staff where user_id = (select user_id from cs425users where username=?)";
		
		int count = jdbcTemplate.queryForObject(sql,new Object[] {userName},Integer.class);
		if(count > 0)
		{
		login.setRole(Constants.ROLE_STAFF);
		Constants.role = Constants.ROLE_STAFF;
		Constants.user = userName;
    	return login;
		}
		else
		{
			login.setRole(Constants.ROLE_MEMBER);
			Constants.role = Constants.ROLE_MEMBER;
			Constants.user = userName;
	    	return login;	
		}		
	}
}