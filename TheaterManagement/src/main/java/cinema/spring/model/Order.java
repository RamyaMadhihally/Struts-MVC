package cinema.spring.model;

public class Order 
{
	private int quantity;
	private double totalPrice;
	private Showing show;
	private String paymentMethod;
	
	public Order()
	{
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Showing getShow() {
		return show;
	}

	public void setShow(Showing show) {
		this.show = show;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	

}
