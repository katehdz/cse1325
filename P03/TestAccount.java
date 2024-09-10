public class TestAccount {
	public static void main(String[] args){

		Account account1 = new Account();
		Account account2 = new Account();

		if (account1.getAccountNumber() !=1){
			System.out.println("Fail: Expected account number 1.")
			System.exit(1);
		}

		if (account2.getAccountNumber() !=2){
			System.out.println("Fail: Expected account number 2.")
			System.exit(1);
		}
	}
}