package customer;

import product.Media;

public class Account {
	private int accountNumber;
	private static int nextaccountNumber=1;

	public Account(){
		this.accountNumber = nextaccountNumber++;
	}

	public int getAccountNumber (){
		return accountNumber;
	}

	public String play(Media media){
		return "Playing " + media.toString();
	}
}