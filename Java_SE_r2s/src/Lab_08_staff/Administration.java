package Lab_08_staff;

public class Administration extends Staff {
	protected double allowance;

	public Administration(String nameStaff, String codeStaff, double baseSalary, int seniority, double allowance) {
		super(nameStaff, codeStaff, baseSalary, seniority);
		this.allowance = allowance;
	}

	public void setAllowance(double allowance) {
		if (this.allowance < 0) {
			this.allowance = 0;
		} else {
			this.allowance = allowance;
		}
	}
	public double getAllowance() {
		return allowance;
	}
	
	@Override
	public double payStaff() {
		return this.baseSalary * this.getCoefficientsSalary() + this.getAllowance();
		
	}
	
	@Override

	public void displayStaff() {
		super.displayStaff();
		System.out.println("Your allowance is : " + this.getAllowance() + "\n" +
		                   "Your salary is : " + this.payStaff());
		System.out.println("\n");
				          
	}
//	public String toString() {
//		return super.toString() + "Employee name administration is: " + this.nameStaff + "\n"
//			 + "Employee code is : " + this.codeStaff + "\n"
//			 + "Basic salary is : " + this.baseSalary + "\n"
//			 + "Years of service is : "+ this.seniority + "\n" +
//			   "Senitory of salary for you : " + this.getCoefficientsSalary();
//			
//	};
	

}
