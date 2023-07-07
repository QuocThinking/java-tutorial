package Lab_08_2_Staff;

public class Administration extends Staff {

	protected double allowAnce;

	public Administration(String nameStaff, String codeStaff, double baseSalary, double seniorityStaff,
			double allowAnce) {
		super(nameStaff, codeStaff, baseSalary, seniorityStaff);
		this.allowAnce = allowAnce;
	}

	public void setAllowAnce(double allowAnce) {
		if (allowAnce < 0) {
			System.out.println("negative numbers are not accepted");
		} else {
			this.allowAnce = allowAnce;
		}
	}
	
	public void payRoll() {
		actualSalary = baseSalary * getCoefficientsSalary() + allowAnce;
	}
	
	public void displayStaff() {
		System.out.println("Name : " + nameStaff + "\n" + 
						   "Code Staff :" + codeStaff + "\n" +
				           "Base Salary : " + format.format(baseSalary) + "\n" +
						   "CoefficientsSalary : " + getCoefficientsSalary() + "\n" +
				           "Allowance :" + format.format(allowAnce) + "\n" +
						   "Actual salary : " +  format.format(actualSalary));
	}

}
