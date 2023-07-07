package Lab_08_staff;

import java.util.Scanner;

public class StaffDemo {
	public static void main(String[] args) {
//		Staff sf1 = new Staff("Quoc", "100-A00", 5000, 14);
//		System.out.println("Employee information one of staff is :\n" + sf1.displayStaff());
//		sf1.payStaff();
//		System.out.println("==========Employee of Marketing=========");
//		Staff sf2 = new Marketing("QuocMarketing", "120-M00", 5000, 14,210000);
//		
//		System.out.println("Employee information one of marketing is :\n" + sf2.displayStaff());
//		sf2.payStaff();
		
		Scanner sc = new Scanner(System.in);
		StaffManager ds = new StaffManager();
		ds.inputStaff();
		ds.outputEmployee();
		System.out.println("Highest paid employee" + "\n" + ds.maxSalary());
		System.out.println("-----------average salary of company-------------");
		System.out.println("Company average salary " + ds.sumSalary());
		
		
	}
}
