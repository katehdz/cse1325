package customer;

import product.Media;

public abstract class Account {
	private int accountNumber;
	private static int nextaccountNumber=1;

	public Account(){
		this.accountNumber = nextaccountNumber++;
	}

	public int getAccountNumber (){
		return accountNumber;
	}

	public abstract String play(Media media);
}