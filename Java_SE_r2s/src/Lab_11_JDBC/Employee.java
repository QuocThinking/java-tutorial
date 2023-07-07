package Lab_11_JDBC;

import java.util.Scanner;

public class Employee {
	private String employeeID, name;
	private float salary;
	
	
	public Employee() {
		super();
	}


	public Employee(String employeeID, String name, float salary) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.salary = salary;
	}


	public String getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public void inputUser(Scanner input) {
		System.out.println("\n*********Enter Employee Information********");
		System.out.print("Enter employee ID: ");
		this.employeeID = input.nextLine();
		System.out.print("Enter name: ");
		this.name = input.nextLine();
		System.out.print("Enter salary: ");
		this.salary = Float.parseFloat(input.nextLine());
	}
	
}
