package Lab_final_test;

import java.util.List;

public class Department {
	private String departmentName;
	private List<Employee> employees;
	
	public Department(String departmentName, List<Employee> employees) {
		
		this.departmentName = departmentName;
		this.employees = employees;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
