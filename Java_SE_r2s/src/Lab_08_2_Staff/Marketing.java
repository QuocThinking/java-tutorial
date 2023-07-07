package Lab_08_2_Staff;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Marketing extends Staff {

	protected double sales, commission;

	public Marketing(String nameStaff, String codeStaff, double baseSalary, double seniorityStaff, double sales) {
		super(nameStaff, codeStaff, baseSalary, seniorityStaff);
		this.sales = sales;
	}

	DecimalFormat format = new DecimalFormat("###,###,###");

	// Locale loc = Locale.getDefault();
	// NumberFormat nf = NumberFormat.getCurrencyInstance(loc);

	Locale lc = new Locale("nv", "VN");
	NumberFormat nf = NumberFormat.getInstance(lc);

	public double getCommission() {
		if (sales < 5000000) {
			return 0;
		} else if (sales < 10000000) {
			return 0.05;
		} else if (sales < 20000000) {
			return 0.1;
		} else {
			return 0.2;
		}

	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		if (sales < 0) {
			System.out.println("negative numbers are not accepted");
		} else {
			this.sales = sales;
		}
	}
	
	public void payRoll() {
		actualSalary = baseSalary * getCoefficientsSalary() + sales * getCommission();
	}
	
	public void displayStaff() {
		System.out.println("Name : " + nameStaff + "\n" + 
						   "Code Staff :" + codeStaff + "\n" +
				           "Base Salary : " + format.format(baseSalary) + "\n" +
						   "CoefficientsSalary : " + getCoefficientsSalary() + "\n" +
				           "Sales :" + format.format(sales) + "\n" +
						   "Actual Salary : " + format.format(actualSalary) );
	}
}
