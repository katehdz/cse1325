package test;

import customer.Account;

public class TestAccount {
	public static void main(String[] args){

		int accountToTest=2;

		for (int i=1; i<= accountToTest; i++){
			Account account = new Account();

			if (account.getAccountNumber() !=i){
			System.out.println("Fail:\nExpected account number " + i + "\nActual account number: " + account.getAccountNumber());
			System.exit(1);
			}
		}
	}
}