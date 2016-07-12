package cinema.spring.model;

public class Movie 
{
	private int id;
	private String title;
	private String genre;
	private double length;
	private int year;
	private String pgRating;
	private String posterUrl;

	public Movie() 
	{
	}

	public Movie(String title, String genre, double length, int year, String pgRating, String posterUrl) {
		this.title = title;
		this.genre = genre;
		this.length = length;
		this.year = year;
		this.pgRating = pgRating;
		this.posterUrl = posterUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getPgRating() {
		return pgRating;
	}

	public void setPgRating(String pgRating) {
		this.pgRating = pgRating;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}