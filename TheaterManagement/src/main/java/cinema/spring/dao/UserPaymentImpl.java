package cinema.spring.dao;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserPaymentImpl implements UserPaymentDAO{

	private JdbcTemplate jdbcTemplate;
	
	public UserPaymentImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public int getUserPaymentRegistrationId(String userName, String paymentMode) 
	{
		int paymentRegistrationId = -1;
		
		String sql="Select paymentreg_id from cs425paymentregistration where user_id = (select user_id from users where username=? and payment_mode=?)";
		
		try
		{
			paymentRegistrationId = jdbcTemplate.queryForObject(sql,new Object[] {userName,paymentMode},Integer.class);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw e;
		}
		return paymentRegistrationId;	
		
	}
}
