package Lab_09_ATM;

import java.util.Scanner;


public class ATM {
	private static int numberOfAccount = 1;
	private String accountID, name,gender,birthday,address,phone,email;
	
	private double balance;
	private int numberOfTransactions;
	
	public String getAccountID() {
		return accountID;
	}
	public double getBalance() {
		return balance;
	}
	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}
	
	public void open() {
	
		Scanner sc = new Scanner(System.in);
		
		accountID = String.format("%03d", ATM.numberOfAccount++);
		
		System.out.print("Enter your name : ");
		name = sc.nextLine();
		System.out.print("Enter your gender : ");
		gender = sc.nextLine();
		System.out.print("Enter your birthday : ");
		birthday = sc.nextLine();
		System.out.print("Enter your address : ");
		address = sc.nextLine();
		System.out.print("Enter your phone : ");
		phone = sc.nextLine();
		System.out.print("Enter your email : ");
		email = sc.nextLine();
		
	}
	
	public void deposit(double amount) {
		balance += amount;
		numberOfTransactions++;
	}
	
	public void widthdraw(double amount) throws MyException {
		if(amount >= balance) {
			//System.out.println("Sorry, but you are " + amount);
			throw new MyException("Sorry, but you are " + amount);
			//return false;
		}else {
			balance -= amount;
			numberOfTransactions++;
			//return true;
			
		}
	}
	@Override
	public String toString() {
		return "ATM [accountID=" + accountID + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", balance=" + balance
				+ ", numberOfTransactions=" + numberOfTransactions + "]";
	}
	

	
	

	
	
	
}
