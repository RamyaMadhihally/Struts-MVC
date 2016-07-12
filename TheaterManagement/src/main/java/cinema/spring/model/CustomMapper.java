package cinema.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class CustomMapper implements RowMapper {
	
	private int userId;
	private String userName;
	private String password;
	private transient String role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomMapper custLogin=new CustomMapper();
		custLogin.setUserName(rs.getString("username"));
		custLogin.setPassword(rs.getString("password"));
		return custLogin;
	}
}
