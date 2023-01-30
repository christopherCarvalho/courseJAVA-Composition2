package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;
import util.DateFormatter;

public class Order {
	
	private LocalDate moment;
	private OrderStatus orderStatus;
	private Client client;
	
	private List<OrderItem> item = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(LocalDate moment, OrderStatus orderStatus,Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public void addItem(OrderItem item) {
		this.item.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.item.add(item);
	}
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem i : item)
		{
			sum += i.subTotal();
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: "+ DateFormatter.fmt.format(getMoment())+"\n");
		sb.append("Order status: "+getOrderStatus()+"\n");
		sb.append("Client: "+client+"\n");
		sb.append("Order items: \n");
				for(OrderItem i : item)
				{
					sb.append(i+ "\n");
				}
		sb.append("Total price: $"+String.format("%.2f", total()));
		return sb.toString();
	}
	
}
