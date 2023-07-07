package Lab_09_ATM;

import java.util.Scanner;

public class ATMMangerment {
	private ATM[] atms;
	private int numberOfATM;

	public ATMMangerment() {
		atms = new ATM[10];
		numberOfATM = 0;
	}

	public void openATM() {
		System.out.println("Your choice : open");
		atms[numberOfATM] = new ATM();
		atms[numberOfATM].open();
		System.out.println("--------Sucessful operation---------");
		System.out.println(atms[numberOfATM]);
		numberOfATM++;
	}

	public void deposit() {
		System.out.println("Your choice : deposit");
		String accNumber;
		double amount;
		ATM foundatm = null;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your account number : ");
		accNumber = sc.nextLine();

		for (int i = 0; i < numberOfATM; i++) {
			if (atms[i].getAccountID().equals(accNumber)) {
				foundatm = atms[i];
				break;
			}
		}
		if (foundatm == null) {
			System.out.println("Account number : " + accNumber + " invalid");
			return;
		}
		
		while(true) {
		try {
			System.out.print("Enter your amount : ");
			amount = Double.parseDouble(sc.nextLine());
			break;
		} catch (Exception e) {
			System.out.println("Amount must be decimal");
		}
	}
		
		foundatm.deposit(amount);
		System.out.println("Your current balance is " + foundatm.getBalance() + "$");
	}

	public void withdraw() {
		System.out.println("Your choice : withdraw");
		String accNumber;
		double amount;
		Scanner sc = new Scanner(System.in);
		ATM foundatm = null;
		
		System.out.println("Enter your account number : ");
		accNumber = sc.nextLine();
		
		for(int i = 0; i < numberOfATM; i++) {
			if(atms[i].getAccountID().equals(accNumber)) {
				foundatm = atms[i];
				break;
			}
		}
		if(foundatm == null) {
			System.out.println("Account number : " + accNumber + " invalid");
			return;
		}
		while(true) {
			try {
				System.out.println("Enter your amount : ");
				amount = Double.parseDouble(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Amount must be decimal");
			}
		}
		
//		if(foundatm.widthdraw(amount)) {
//			System.out.println("Your current balance is " + foundatm.getBalance() + "$");
//		}
		try {
			foundatm.widthdraw(amount);
			System.out.println("Your current balance is " + foundatm.getBalance() + "$");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void show() {
		System.out.println("Your choice : show");
		String accNumber;
		double amount;
		ATM foundatm = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your account number : ");
		accNumber = sc.nextLine();
		for(int i = 0; i < numberOfATM; i++) {
			if(atms[i].getAccountID().equals(accNumber)) {
				foundatm = atms[i];
				break;
			}
		}
		if(foundatm == null) {
			System.out.println("Account number : " + accNumber + " invalid");
			return;
		}
		System.out.println("The number of transactions are " + foundatm.getNumberOfTransactions());
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		ATMMangerment atmss = new ATMMangerment();
		
		while (true) {
			System.out.println("Open an account (enter: open)");
			System.out.println("Make a deposit (enter: deposit)");
			System.out.println("Make a withdraw (enter: withdraw)");
			System.out.println("Show the number of transactions (enter: show)");
			System.out.println("Exit the ATM (enter: quit)");
			System.out.print("\nYour choice: ");
			choice = sc.nextLine();

			switch (choice) {
			case "open":
				atmss.openATM();
				break;
			case "deposit":
				atmss.deposit();
				break;
			case "withdraw":
				atmss.withdraw();
				break;
			case "show":
				atmss.show();
				break;
			case "quit":
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("Invalid option!");
				break;
			}
		}
	
	}

}
