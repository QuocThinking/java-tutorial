package Lab_07_Account;

import java.util.Scanner;

public class Account {
	private String pinCode;
	private String accountName;
	private double accountBalance;

	public Account(double accountBalance, String accountName) {

		this.accountBalance = accountBalance;
		this.accountName = accountName;
	}

//	public double getaccountBalance() {
//		return accountBalance;
//	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public double withdrawMoney(double amount) {
		if (this.pinCode.equals("1234567")) {
			if (amount <= accountBalance) {
				accountBalance -= amount;
				return amount;
			} else {
				System.out.println("the amount in the account is not enough");
				return 0;
			}
		}
		System.out.println("wrong pin code");
		return 0;

	}

	public void transFer(Account account, double amount) {
		double check = this.withdrawMoney(amount);
		if (check != 0) {
			account.accountBalance += amount;
			System.out.println("money transfer successful");
		}
	}
}
