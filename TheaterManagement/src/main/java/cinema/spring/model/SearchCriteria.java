package cinema.spring.model;


public class SearchCriteria {
	
	private Movie movie;
	private Actor actor;
	private Director director;
	private Writer writer;

	public SearchCriteria() 
	{
	}

	public SearchCriteria(Movie movie, Actor actor)
	{
		setMovie(movie);
		setActor(actor);
	}
	

	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) 
	{
		this.actor = actor;
	}

	public Director getDirector() 
	{
		return director;
	}

	public void setDirector(Director director) 
	{
		this.director = director;
	}

	public Writer getWriter() 
	{
		return writer;
	}

	public void setWriter(Writer writer) 
	{
		this.writer = writer;
	}


}