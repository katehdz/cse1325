public class Coin {

	//private fields
	private Denomination denomination;
	private int year;

	//public constructor
	public Coin(Denomination denomination, int year){
		this.denomination =denomination;
		this.year =year;
	}

	//public method 1
	public double getValue() {
		switch (denomination) {
			case PENNY: return 0.01;
			case NICKEL: return 0.05;
			case DIME: return 0.10;
			case QUARTER: return 0.25;
			default: return 0.00;
		}
	}

	//public method 2
	public int getYear() {
		return year;
	}
}