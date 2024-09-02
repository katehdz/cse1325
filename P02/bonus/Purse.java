//Kaitlynn Hernandez CSE1325 P02 Bonus

public class Purse {
	public static void main (String[] args){

		//create coin array
		Coin[] coins = {
			new Coin(Denomination.PENNY, 1905),
			new Coin(Denomination.QUARTER, 1975),
			new Coin(Denomination.DIME, 1976),
			new Coin(Denomination.NICKEL, 1981),
			new Coin(Denomination.DIME, 2020)
		};

		double total=0.00;
		int earliestCoin = Integer.MAX_VALUE;
		int latestCoin = Integer.MIN_VALUE;

		//for each leap
		for(Coin coin : coins){
			//print each coin first 
			System.out.println(coin);

			total += coin.getValue();
			int year = coin.getYear();
			

			//finding early and latest coin
			if (year < earliestCoin){
				earliestCoin = year;
			}
			if (year> latestCoin){
				latestCoin = year;
			}
		}
		//print total
		System.out.printf("You have $ %.2f in coins between %d and %d%n", total, earliestCoin, latestCoin);
	}
}