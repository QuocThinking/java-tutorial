package Lab_07_Account;

public class AccountManagement {
	public static void main(String[] args) {
	Account firstAccount = new Account(200, "Quoc");
	Account secondAccount = new Account(100,"Nhan");
	
	firstAccount.setPinCode("1234567");
	System.out.println("Số dư tài khoản firstAccount : " + firstAccount.getAccountBalance());
	System.out.println("Số dư tài khoản secondAccount : " + secondAccount.getAccountBalance());
	firstAccount.withdrawMoney(300);
	System.out.println("Số dư tài khoản firstAccount sau khi rút : " + firstAccount.getAccountBalance());
	firstAccount.withdrawMoney(150);
	System.out.println("Số dư tài khoản firstAccount sau khi rút : " + firstAccount.getAccountBalance());
	System.out.println("Tk firstAccount chuyển tiền cho secondAccount");
	firstAccount.transFer(secondAccount, 50);
	System.out.println("Số dư tài khoản secondAccount :" + secondAccount.getAccountBalance());
	}
	
}
