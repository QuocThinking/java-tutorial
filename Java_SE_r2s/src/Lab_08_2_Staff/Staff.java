package Lab_08_2_Staff;

import java.io.ObjectInputFilter.Config;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.security.auth.login.ConfigurationSpi;

public class Staff {
	protected String nameStaff;
	protected String codeStaff;
	protected double baseSalary;
	protected double coefficientsSalary;
	protected double seniorityStaff, actualSalary;

	public Staff(String nameStaff, String codeStaff, double baseSalary, double seniorityStaff) {
		super();
		this.nameStaff = nameStaff;
		this.codeStaff = codeStaff;
		this.baseSalary = baseSalary;
		this.seniorityStaff = seniorityStaff;
	}
	
	DecimalFormat format =  new DecimalFormat("###,###,###");
	
	/**
	 * phụ cấp
		không chấp nhận số âm
		sỉ số nhân viên
		nhập danh sách
		xuất danh sách
		lương cao nhất
		Lương thực tế
		Lương trung bình toàn công ty là:
	 */
	
	/**\
	 * allowance
		negative numbers are not accepted
		number of employees
		enter list
		export list
		highest salary
		Actual salary
		The company-wide average salary is:
	 */
	
	public double getActualSalary() {
		return actualSalary;
	}
	
	public double getCoefficientsSalary() {
		if(seniorityStaff < 5) {
			return 1;
		} 
		return 1 + (int) (seniorityStaff/5);
	}
	
	public void setSeniorityStaff(double seniorityStaff) {
		if(seniorityStaff < 0) {
			System.out.println("negative numbers are not accepted");
		}
		this.seniorityStaff = seniorityStaff;
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
	
	public void payRoll() {
		actualSalary = baseSalary * getCoefficientsSalary();
	}
	
	public void displayStaff() {
		System.out.println("Name : " + nameStaff + "\n" + 
						   "Code Staff :" + codeStaff + "\n" +
				           "Base Salary : " + format.format(baseSalary) + "VNĐ" + "\n" +
						   "CoefficientsSalary : " + getCoefficientsSalary() + "\n" +
				           "Actual Salary : " + format.format(actualSalary));
	}
}
