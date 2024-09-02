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

	//public method to get weight
	public double getWeight(){
		switch (denomination){
			case PENNY:
				if (year <1983) return 3.110;
				else return 2.500;
			case NICKEL:
				return 5.000
			case DIME:
				if (year <1965) return 2.500;
				else return 2.268;
			case QUARTER:
				if (year <1965) return 6.250;
				else return 5.670;
		}
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