package cinema.spring.model;

public class Director extends Person
{
	private int directorid;
	private int movieid;
	public Director()
	{
		super();
	}
	public Director(int directorid,int movieid) {
		this.directorid = directorid;
		this.movieid = movieid;
		
		
	}
	public int getDirectorid() {
		return directorid;
	}
	public void setDirectorid(int directorid) {
		this.directorid = directorid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	
}
