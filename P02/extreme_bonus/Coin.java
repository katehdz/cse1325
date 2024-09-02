public class Coin {

	//private fields 
	private Denomination denomination;
	priavte int year;

	//public constructor
	public Coin(Denomination denomination, int year){
		this.denomination =denomination;
		this.year =year;
	}
	//public method to get value
	public double getValue(){
		return denomination.getValue();
	}
}