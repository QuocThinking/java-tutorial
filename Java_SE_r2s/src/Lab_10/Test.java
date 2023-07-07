package Lab_10;

import java.util.List;
import java.util.Scanner;

//import buoi10.bai1.Order;

public class Test {
	
	public static void main(String[] args) {
		SaleManagement saleManagement = new SaleManagement();
		Scanner sc = new Scanner(System.in);
		int choice;
		String phone;
		
		while(true) {
		System.out.println("Choose function: ");
		System.out.println("1. Add a new Customer");
		System.out.println("2. Show all Customers");
		System.out.println("3. Search Orders");
		System.out.println("4. Remove Customer");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
		
		choice = Integer.parseInt(sc.nextLine());
		
		switch (choice) {
		case 1:
			saleManagement.createCustomer();
			break;
		case 2:
			saleManagement.display(saleManagement.findAll());
			break;
		case 3:
			System.out.print("Enter customer phone number u want to search: ");
			phone = sc.nextLine();
			List<Order> foundOrders = saleManagement.search(phone);
			if (foundOrders == null) {
				System.out.println("Can not find orders with given customer phone number!");
			} else {
				System.out.println("Found orders: " + foundOrders);
			}
			break;
		case 4:
			System.out.print("Enter customer phone number u want to remove: ");
			phone = sc.nextLine();
			if (saleManagement.remove(phone)) {
				System.out.println("Remove customer successfully!");
			} else {
				System.out.println("Remove customer unsuccessfully!");
			}
			break;
		case 5:
			System.out.println("Goodbye!");
			return;
		default:
			System.out.println("Invalid choice!");
			break;
		}
	}
}}
