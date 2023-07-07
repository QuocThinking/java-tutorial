package lab_07_2_Account;

public class AccountManagement {
	public static void main(String[] args) {
		Account firstAccount = new Account("Le Quoc", 200);
		Account secondAccount = new Account("Le La", 150);
		
		firstAccount.setPinCode("1234567");
		System.out.println("Account Balance of firstAccount is : " + firstAccount.getAccountBalance());
		
		//Failed
		firstAccount.withdrawMoney(300);
		//success
		firstAccount.withdrawMoney(50);
		
		//transer
		firstAccount.transFer(secondAccount, 75);
		System.out.println("Account Balance of secondAccount is : " + secondAccount.getAccountBalance());
	}
}
