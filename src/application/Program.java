package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import util.DateFormatter;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birth date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),DateFormatter.fmt);		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		Order order = new Order(LocalDate.now(),OrderStatus.valueOf(orderStatus),new Client(name,email,date));
		
		System.out.print("How many itens to this order? ");
		int n =sc.nextInt();
		
		for(int i=0; i<n; i++)
		{	
			System.out.println("Enter #"+(i+1)+" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			Product product = new Product(productName,productPrice);
			OrderItem orderItem = new OrderItem(quantity,productPrice,product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();
	}

}
