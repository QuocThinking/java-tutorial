package Lab_08_staff;

import java.util.Scanner;

public class StaffManager {
	private Staff[] listStaff;
	private int listEmployee;

	public StaffManager() {
		listStaff = new Staff[100];
		this.listEmployee = 0;
	}

	public void inputStaff() {
		Scanner sc = new Scanner(System.in);
		String nameStaff;
		String codeStaff;
		double baseSalary;
		int seniority, sales;
		double allowance;
		System.out.println("Enter a number of employees");
		this.listEmployee = sc.nextInt();
		int option;
		for (int i = 0; i < this.listEmployee; i++) {
			System.out.println("Enter employee : " + (i + 1));
			System.out.println("Enter employee type:\r\n"
					+ "1 is marketing or 2 is Administrator");
			option = sc.nextInt();
			sc.nextLine();
			// Marketing Employee
			if(option == 1) {
				System.out.println("Enter employee name");
				nameStaff = sc.nextLine();
				System.out.println("Enter employee code");
				codeStaff = sc.nextLine();
				System.out.println("Enter basic salary");
				baseSalary = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter seniority");
				seniority = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter sales");
				sales = sc.nextInt();
				this.listStaff[i] = new Marketing(nameStaff,codeStaff,baseSalary,seniority,sales);
				
			} else {
				System.out.println("Enter employee name");
				nameStaff = sc.nextLine();
				System.out.println("Enter employee code");
				codeStaff = sc.nextLine();
				System.out.println("Enter basic salary");
				baseSalary = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter seniority");
				seniority = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter allowance");
				allowance = sc.nextDouble();
				this.listStaff[i] = new Administration(nameStaff,codeStaff,baseSalary,seniority,allowance);
			}
		}
	}
		public void outputEmployee() {
			System.out.println("List of employee is  : ");
			for(int i = 0 ; i < this.listEmployee; i++ ) {
				this.listStaff[i].displayStaff();
			}
		}
		
		public Staff maxSalary() {
			Staff maxStaff = this.listStaff[0];
			for(int i = 0 ; i < this.listEmployee; i++) {
				if(maxStaff.payStaff() < this.listStaff[i].payStaff())
					maxStaff = listStaff[i];
			}
			return maxStaff;
		}
		
		public double sumSalary() {
			double sumStaff = 0;
			for (int i = 0; i < this.listEmployee ;i++) {
				sumStaff += listStaff[i].payStaff();
			}
			return sumStaff/this.listEmployee;
		}

	}


