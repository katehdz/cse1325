public class Coin {

	//private fields
	private Denomination denomination;
	private int year;

	//public contructor
	public Coin(Denomination denomination, int year){
		this.denomination =denomination;
		this.year =year;
	}

	//public method to get value
	public double getValue() {
		return denomination.getValue();
	}

	//public method to get year
	public int getYear(){
		return year;
	}

	@Override
	public String toString(){
		return year + " " + denomination.toString();
	}
}