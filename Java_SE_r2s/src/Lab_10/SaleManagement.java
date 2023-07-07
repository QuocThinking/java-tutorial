package Lab_10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import buoi10.bai1.Order;

public class SaleManagement {
	private List<Customer> customers;
	
	public SaleManagement() {
		customers = new ArrayList<>();
	}

	public void createCustomer() {
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();

		System.out.print("Enter customer name :");
		customer.setName(sc.nextLine());

		while (true) {
			try {
				System.out.print("Enter customer phone :");
				customer.setPhone(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		System.out.print("Enter customer address : ");
		customer.setAddress(sc.nextLine());

		String decision;
		List<Order> orders = new ArrayList<Order>();
		while (true) {
			System.out.print("Do you want to continue (n or N to quit) :");
			decision = sc.nextLine();

			if (decision.equalsIgnoreCase("n")) {
				break;
			}

			
			Order order = new Order();
			while (true) {
				try {
					System.out.println("Enter Order number : ");
					order.setNumber(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");

			while (true) {
				try {
					System.out.println("Enter order day ");
					order.setDate(simpleDateFormat.parse(sc.nextLine()));
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			orders.add(order);
		}
		customer.setOrders(orders);
		customers.add(customer);
	}
	public List<Customer> findAll(){
		return customers;
	}
	public void display(List<Customer> customers) {
		if (customers == null) {
			System.out.println("[SaleManagement] Error: display customers = null");
			return;
		}
		System.out.printf("%-20s|%-15s|%-15s|%-50s\n", "Customer Name", "Address", "Phone Number", "Order List");
		for(int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			System.out.printf("%-20s|%-15s|%-15s|%-50s\n", customer.getName(), customer.getAddress(),customer.getPhone(), customer.getOrders());
			
		}
	}
	public List<Order> search(String phone){
		for(int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if(customer.getPhone().equals(phone)) {
				return customer.getOrders();
			}
		}
		return null;
	}
	
	public boolean remove(String phone) {
		Customer foundCustomer = null;
		for(int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if(customer.getPhone().equals(phone)) {
				foundCustomer = customer;
				break;
			}
		}
		return customers.remove(foundCustomer);
	}
}
