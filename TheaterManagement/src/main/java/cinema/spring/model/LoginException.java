package cinema.spring.model;

@SuppressWarnings("serial")
public class LoginException extends RuntimeException{
private String exceptionMsg;

public LoginException(String exceptionMsg) {
	
	this.exceptionMsg = exceptionMsg;
}

public String getExceptionMsg() {
	return exceptionMsg;
}

public void setExceptionMsg(String exceptionMsg) {
	this.exceptionMsg = exceptionMsg;
}

}
