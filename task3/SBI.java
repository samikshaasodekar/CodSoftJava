package task3;

class SBI implements Bank {
	
	public void deposite(float amt) {  
		System.out.println("Rs." + amt + "Credited to SBI Account");
	}
	
	public void withdraw(float amt) {
		System.out.println("Rs." + amt + "Debited from SBI Account");
	}

}