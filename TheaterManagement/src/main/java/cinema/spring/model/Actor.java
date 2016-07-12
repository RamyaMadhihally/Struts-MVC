package cinema.spring.model;


public class Actor extends Person
{
	private int actorid;
	private int movieid;
	private String roleName;
	public Actor()
	{
		
	}
	public Actor(String name) 
	{
		super(name);
	}

	public Actor(int actorid,int movieid,String roleName) {
		this.actorid = actorid;
		this.movieid = movieid;
		this.roleName = roleName;		
	}

	public int getActorid() {
		return actorid;
	}
	public void setActorid(int actorid) {
		this.actorid = actorid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}	
}
