package test;

import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import product.Media;

public class TestAccount {
	public static void main(String[] args){
		int accountToTest=2;

		for (int i=1; i<= accountToTest; i++){
			Account account = new Unlimited();

			if (account.getAccountNumber() !=i){
			System.out.println("Fail:\nExpected account number " + i + "\nActual account number: " + account.getAccountNumber());
			System.exit(1);
			}
		}

		// Check Unlimited and Alacarte
        Unlimited unlimitedAccount = new Unlimited();
        Alacarte alacarteAccount = new Alacarte();
        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 10);


        // Test buying points
        alacarteAccount.buyPoints(15); // Adding points
        if (alacarteAccount.getPointsRemaining() != 15) {
            System.out.println("Fail:\nExpected points remaining: 15\nActual points remaining: " + alacarteAccount.getPointsRemaining());
            System.exit(1);
        }

        String result = unlimitedAccount.play(media);
        if (!result.equals("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 10 points)")) {
            System.out.println("Fail:\nExpected: Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 10 points)\nActual: " + result);
            System.exit(1);
        }
        // Test playing media with enough points
        result = alacarteAccount.play(media);
        if (!result.equals("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 10 points)")) {
            System.out.println("Fail:\nExpected: Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 10 points)\nActual: " + result);
            System.exit(1);
        }

        // Manually reset points to 0
        alacarteAccount = new Alacarte(); // Creating a new instance to ensure pointsRemaining is 0
        result = alacarteAccount.play(media);
        if (!result.equals("Buy more points: Requires 10 points, you have 0 points")) {
            System.out.println("Fail:\nExpected: Buy more points: Requires 10 points, you have 0 points\nActual: " + result);
            System.exit(1);
        }
	}
}
