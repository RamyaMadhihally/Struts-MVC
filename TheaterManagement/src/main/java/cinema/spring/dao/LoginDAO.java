package cinema.spring.dao;



import cinema.spring.model.CustomMapper;

import cinema.spring.model.LoginException;

public interface LoginDAO {

public CustomMapper validateUser(String userName, String password) throws LoginException;
}
