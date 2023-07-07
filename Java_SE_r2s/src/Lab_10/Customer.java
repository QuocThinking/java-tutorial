package Lab_10;

import java.util.List;

public class Customer {
	private String name, phone, address;
	private List<Order> orders;

	public Customer() {

	}

	public Customer(String name, String phone, String address, List<Order> orders) throws Exception {
		this.name = name;
		this.setPhone(phone);
		this.address = address;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws Exception {
		if (phone == null || phone.length() != 10 || phone.charAt(0) != '0' || phone.equals("0000000000")) {
			throw new Exception("[Customer] Error : Invalid phone number format!");
		} else {
			this.phone = phone;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

}
