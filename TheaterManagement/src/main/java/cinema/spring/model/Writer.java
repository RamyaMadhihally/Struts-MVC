package cinema.spring.model;

public class Writer extends Person
{
	private int writerid;
	private int movieid;
	public Writer()
	{
		super();
	}

	public Writer(int writerid,int movieid) {
		this.writerid = writerid;
		this.movieid = movieid;
		
		
	}

	public int getWriterid() {
		return writerid;
	}

	public void setWriterid(int writerid) {
		this.writerid = writerid;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	
}
