package lab_07_2_Account;

public class Account {
	
	/**@author Lequoc
	 * mã pin
		số dư tài khoản
		tên tài khoản
		rút tiền
		số tiền trong tài khoản không đủ để rút
		chuyển khoản
		số dư tài khoản
		
			pin code
			account balance
			account name
			withdraw money
			the amount in the account is not enough to withdraw
			transfer
			account balance
	 */
	private String pinCode, accountName;
	private double accountBalance;

	public Account(String accountName, double accountBalance) {
		super();
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public double withdrawMoney(double amount) {
		if (this.pinCode.equals("1234567")) {
			if (amount <= this.accountBalance) {
				this.accountBalance -= amount;
				return amount;
			} else {
				System.out.println("the amount in the account is not enough to withdraw");
				return 0;
			}
		} else {
			System.out.println("Wrong Pin");
			return 0;
		}
	}

	public void transFer(Account account, double amount) {
		double check = this.withdrawMoney(amount);
		if (check != 0) {
			this.accountBalance += amount;
			System.out.println("Transfer successfully");
		}
	}
}
