package Lab_08_staff;

public class Staff {
	protected String nameStaff;
	protected String codeStaff;
	protected double baseSalary,actualSalary;
	protected int seniority,coefficientsSalary;//hesoluong
	public Staff(String nameStaff, String codeStaff, double baseSalary, int seniority) {
		
		this.nameStaff = nameStaff;
		this.codeStaff = codeStaff;
		this.baseSalary = baseSalary;
		this.seniority = seniority;
	}
	
	/** 
	 * 
	 * @hê so luong
	 * 5 năm tăng hệ số 1 bậc - mặc định he số là 1
	 */
	
	public int getCoefficientsSalary() {
		return this.coefficientsSalary = (1 + this.seniority/5);
	}
	/**
	 * Thâm niên công tác ko chấp nhận số âm
	 */
	
	public void setSeniority(int seniority) {
		if(this.seniority < 0) {
			this.seniority = 0;
		}else {
			this.seniority = seniority;
		}
	}

	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public String getCodeStaff() {
		return codeStaff;
	}

	public void setCodeStaff(String codeStaff) {
		this.codeStaff = codeStaff;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double payStaff() {
		return this.baseSalary * this.getCoefficientsSalary();
		
	}
	
	public void displayStaff() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Employee name is: " + this.nameStaff + "\n"
			 + "Employee code is : " + this.codeStaff + "\n"
			 + "Basic salary is : " + this.baseSalary + "\n"
			 + "Years of service is : "+ this.seniority + "\n" +
			   "Coefficients salary for you : " + this.getCoefficientsSalary();
			
	};
	

	
	
}
