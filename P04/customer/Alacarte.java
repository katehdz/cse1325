package customer;

import product.Media;

public class Alacarte extends Accounts {
	private int pointsRemaining;

	public void buyPoints(int points){
		pointsRemaining += points;
	}

	public int getPointsRemaining(){
		return pointsRemaining;
	}

	@Override
	public String play(Media media){
		int mediaPoints = media.getPoints():

		if (pointsRemaining >= mediaPoints){
			pointsRemaining-= mediaPoints;
			return "Playing " + media.toString();
		} else {
			return "Buy more points: Requires " + mediaPoints + " points, you have " + pointsRemaining;
		}
	}
}