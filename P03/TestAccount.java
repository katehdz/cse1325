public class TestAccount {
	public static void main(String[] args){

		Account account1 = new Account();
		Account account2 = new Account();

		if (account1.getAccountNumber() !=1){
			System.out.println("Fail:\nExpected account number: 1.\nActual account number: " + account1.getAccountNumber());
			System.exit(1);
		}

		if (account2.getAccountNumber() !=2){
			System.out.println("Fail:\nExpected account number: 2.\nActual account number: " + account2.getAccountNumber());
			System.exit(1);
		}
	}
}