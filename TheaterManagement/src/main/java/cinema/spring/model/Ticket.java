package cinema.spring.model;

import java.util.Date;

public class Ticket 
{
	private int ticketId;
	private int paymentRegistratonId;
	private String roomNumber;
	private Date startTime;
	
	public Ticket()
	{
		
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getPaymentRegistratonId() {
		return paymentRegistratonId;
	}

	public void setPaymentRegistratonId(int paymentRegistratonId) {
		this.paymentRegistratonId = paymentRegistratonId;
	}

}
