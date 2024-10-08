package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Account {
	private int accountNumber;
	private static int nextaccountNumber=1;

	public Account(){
		this.accountNumber = nextaccountNumber++;
	}

	public Account(BufferedReader br) throws IOException {
		this.accountNumber = Integer.parseInt(br.readLine());
		nextaccountNumber = Integer.parseInt(br.readLine());
	}

	public void save(BufferedWriter bw) throws IOException {
		bw.write(Integer.toString(accountNumber) + "\n");
		bw.write(Integer.toString(nextaccountNumber) + "\n");
	}
	public int getAccountNumber (){
		return accountNumber;
	}

	public abstract String play(Media media);
}
