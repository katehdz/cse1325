package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Student {
	private String name;
	private int id;
	private String email;
	private Account account;

	public Student(String name, int id, String email, boolean unlimited) {

    if (email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")) {
        this.name = name;
        this.id = id;
        this.email = email;

        if (unlimited) {
            this.account = new Unlimited();
        } else {
            this.account = new Alacarte();
        }
    } else {
        throw new IllegalArgumentException("Non-UTA email address: " + email);
    	}
	}
	
	public Student (BufferedReader br) throws IOException {
		this.name= br.readLine();
		this.id = Integer.parseInt(br.readLine());
		this.email = br.readLine();

		String accountType = br.readLine();
		if (accountType.equals("alacarte")) {
            this.account = new Alacarte(br);  
        } else if (accountType.equals("unlimited")) {
            this.account = new Unlimited(br);  
        } else {
            throw new IOException("Unknown account type: " + accountType);
        }
	}

	public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n"); 
        bw.write(Integer.toString(id) + "\n");  
        bw.write(email + "\n");  

        // Write account type (either "alacarte" or "unlimited")
        if (account instanceof Alacarte) {
            bw.write("alacarte\n");
        } else if (account instanceof Unlimited) {
            bw.write("unlimited\n");
        }
        account.save(bw);  
    }

	public String requestMedia(Media media){
		return account.play(media);
	}

	public Account getAccount(){
		return account;
	}
	@Override
	public String toString(){
		return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";

	}
}