/*
TASK 3
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.
*/

package task3;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Which bank's card? [1.SBI |2.ICICI]: ");
		int cardType = sc.nextInt();
		
		Bank bank;
		
		switch(cardType) {
		
		case 1:
			bank = new SBI();
			break;
			
		case 2:
			bank = new ICICI();
			break;	
			
		default:
			System.out.println("Card Read Error ------ Try Again");
			return;
		}
		System.out.println();
        System.out.println("======= WELCOME TO " + bank.getClass().getSimpleName().toUpperCase() + " ");
        
        bank.deposite(1000);
        bank.withdraw(500);
        
        System.out.println(bank.n);
        System.out.println(Bank.n);
        System.out.println(SBI.n);
        System.out.println(ICICI.n);
        
	}

}

