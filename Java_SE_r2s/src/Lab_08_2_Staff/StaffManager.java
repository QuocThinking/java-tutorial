package Lab_08_2_Staff;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class StaffManager {
	private Staff[] staff;
	private int numberOfEmployee;

	public StaffManager() {
		staff = new Staff[100];
		this.numberOfEmployee = 0;
	}

	public void enterList() {
		staff[0] = new Marketing("Le Quoc", "AM0091", 10000000, 4, 10000000);
		staff[1] = new Administration("Le Ngoc", "AA0034", 8000000, 3, 5000000);
		staff[2] = new Marketing("Nguyen Linh", "AM0031", 18000000, 7, 11500000);
		staff[3] = new Staff("Nguyen Hoai", "AS045", 8_000000, 3);
		staff[4] = new Administration("Mai Tam", "AA0031", 9000000, 4.5, 6000000);
		staff[5] = new Administration("Le My", "AA0093", 16000_000, 7, 10000000);
		staff[6] = new Marketing("Le Ku", "AM0066", 15000000, 10, 20000000);
		staff[7] = new Marketing("Hoai Loc", "AM0061", 12000000, 8, 25000000);
		staff[8] = new Administration("Le Hai", "AM0551", 15000000, 12, 20000000);
		numberOfEmployee = 9;
		for (int i = 0; i < numberOfEmployee; i++) {
			staff[i].payRoll();
		}

	}

	Locale localeVN = new Locale("vi", "VN");
	NumberFormat vn = NumberFormat.getInstance(localeVN);
	DecimalFormat format = new DecimalFormat("###,###,###");
	
	public void exportList() {
		System.out.println("List of Employee :");
		for(int i = 0; i < numberOfEmployee; i++) {
			staff[i].displayStaff();
		}
		System.out.println("\n");
	}
	
	public void highestSalary() {
		staff[0].payRoll();
		double maxSalary = staff[0].getActualSalary();
		int index = 0;
		for(int i = 0; i < numberOfEmployee; i++) {
			staff[i].payRoll();
			if(maxSalary < staff[i].getActualSalary()) {
				index = i;
				maxSalary = staff[i].getActualSalary();
			}
		}
		System.out.println("The highest salary of employee is ");
		staff[index].displayStaff();
	}
	
	public void sumSalary() {
		double sum = 0;
		for(int i = 0 ; i < numberOfEmployee; i++) {
			staff[i].payRoll();
			sum += staff[i].getActualSalary();
		}
		System.out.println("The company's average salary is : " + format.format(sum/numberOfEmployee));
		
	}
	

	public static void main(String[] args) {
		StaffManager staff_1 = new StaffManager();
		staff_1.enterList();
		staff_1.exportList();
		staff_1.highestSalary();
		staff_1.sumSalary();
	}

}
