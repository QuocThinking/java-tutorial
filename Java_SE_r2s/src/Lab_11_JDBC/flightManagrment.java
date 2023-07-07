package Lab_11_JDBC;

import java.util.List;
import java.util.Scanner;

public class flightManagrment {
	public static void showmenu() {
		
		System.out.println("View staff list: (1) ");
		System.out.println("View flight list: (2)");
		System.out.println("See list of certifications: (3)");
		System.out.println("See the list of aircraft: (4)");
		System.out.println("Add new staff: (5)");
		System.out.println("Quit: (6)");
		
	}
	public static void main(String[] args) {
		int choice;
		Employee employee;
		UserEdit userEdit = new UserEdit();
		Scanner sc = new Scanner(System.in);
		choice = Integer.parseInt(sc.nextLine());
		do {
			showmenu();
			switch (choice) {
			case 1:
				System.out.println("***********List of Employee***********");
				System.out.println("MaNV\t\tTen\t\tLuong");
				List<Employee> employees = userEdit.findAll();
				for(Employee e:employees)
					System.out.println(e);
				System.out.println("Total Employee : " + employees.size());
				System.out.println("=================**********============");
				break;
			case 2:
				break;
			default:
				System.out.println("Please select your choice from 1 to 5. Thank you!");
				break;
			}
		}while(choice != 5);
	}
}
