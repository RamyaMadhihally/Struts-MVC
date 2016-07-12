package cinema.spring.model;

import java.sql.Date;
import java.sql.Timestamp;



public class Showing {
	
	private int movieId;
	private int showid;
	private String title;
	

	private String roomNumber;
	private int availableSeats;
	private Timestamp startTime;
	private double price;
	
	public Showing() {
	}

	public Showing(int movieId,int showid,String title,String roomNumber, int availableSeats, Timestamp startTime, Date showDate, double price) {
		this.showid =showid;
		this.movieId = movieId;
		this.title = title;
		this.roomNumber = roomNumber;
		this.availableSeats = availableSeats;
		this.startTime = startTime;
		this.price = price;

	}
	public int getshowid() {
		return showid;
	}

	public void setshowid(int showid) {
		this.showid = showid;
	}	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int id) {
		this.movieId = id;
	}
	
	public String getroomNumber() {
		return roomNumber;
	}

	public void setroomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getavailableSeats() {
		return availableSeats;
	}

	public void setavailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Timestamp getstartTime() {
		return startTime;
	}

	public void setstartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
