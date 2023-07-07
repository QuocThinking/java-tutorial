package Lab_final_test;

public class HourlyEmployee extends Employee {
	private double wage, workingHours;

	public HourlyEmployee(double wage, double workingHours) {
		super();
		this.wage = wage;
		this.workingHours = workingHours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	

}
