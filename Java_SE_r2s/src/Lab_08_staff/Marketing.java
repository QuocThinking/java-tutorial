package Lab_08_staff;

public class Marketing extends Staff {
	protected double comission;
	protected int sales;

	public Marketing(String nameStaff, String codeStaff, double baseSalary, int seniority, int sales) {
		super(nameStaff, codeStaff, baseSalary, seniority);
		this.sales = sales;

	}
	
	

	public int getSales() {
		return this.sales;
	}



	public double getComission() {
		if (this.sales >= 50000 && this.sales < 100000) {
			return 0.05;
		} else if (this.sales >= 100000 && this.sales < 200000) {
			return  0.1;
		} else {
			return  0.2;
		}
		
	}

	public void setSales(int sales) {
		if (sales < 0) {
			this.sales = 0;
		} else {
			this.sales = sales;
		}
	}
	
	@Override
	public double payStaff() {
		return (this.baseSalary * this.getCoefficientsSalary()) + (this.getSales() * this.getComission());
		
	}

	public void displayStaff() {
		super.displayStaff();
		System.out.println("Your sales is " + this.getSales() + "\n"
				          +"Your comission is " + this.getComission() + "\n"
				          +"Your salary is : " + this.payStaff());
		System.out.println("\n");
	}
	
//	@Override
//	public String toString() {
//		return super.toString() +  "Employee name of marketing is: " + this.nameStaff + "\n"
//			 + "Employee code is : " + this.codeStaff + "\n"
//			 + "Basic salary is : " + this.baseSalary + "\n"
//			 + "Years of service is : "+ this.seniority + "\n" +
//			   "Your coefficients is : " + this.getCoefficientsSalary();
//			
//	};

}
