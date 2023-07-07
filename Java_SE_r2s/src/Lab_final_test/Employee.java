package Lab_final_test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public abstract class Employee {
	private String ssn, firstName, lastname, birthDate, phone, email;

	public Employee() {
		super();
	}

	public Employee(String ssn, String firstName, String lastname, String birthDate, String phone, String email) throws Exception {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastname = lastname;
		this.birthDate = birthDate;
		this.setPhone(phone);
		this.setEmail(email);
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthDate() {
		return birthDate;
	}
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws Exception {
		if (phone == null || phone.length() != 10 || phone.charAt(0) != '0' || phone.equals("0000000000")) {
			throw new Exception("[Customer] Error : Invalid phone number format!");
		} else {
			this.phone = phone;
		}
	}

	public String getEmail() {
		return email;
	}

	
	
	
	public void setEmail(String email) throws Exception {
		if (email == null || email.isEmpty()) {
			 throw new Exception ("Invalid");
		
		}
//		String emailRegex = "^(.+)@(\\\\S+)$";
//		
////		Pattern pattern = Pattern.compile(emailRegex);
//		if (pattern.matcher(email).matches()) {
//			
//			
		 else {
			this.email = email;
		}
	}
		
	
	public String validateEmail(String email) {
		if (email == null || email.isEmpty()) {
			return ("Invalid");
		}
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches()) {
			return "Valid";
		} else {
			return "Invalid";
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Employee [ssn=" + ssn + ", firstName=" + firstName + ", lastname=" + lastname + ", birthDate="
				+ dateFormat.format(birthDate) + ", phone=" + phone + ", email=" + validateEmail(email) + "]";
	}

}
