package customer;

import product.Media;

public class Alacarte extends Account {
	private int pointsRemaining=0;


	public void buyPoints(int points){
		if (points > 0){
		pointsRemaining += points;
		}
	}

	public int getPointsRemaining(){
		return pointsRemaining;
	}

	@Override
	public String play(Media media){
		int mediaPoints = media.getPoints();
		if (pointsRemaining >= mediaPoints){
			pointsRemaining-= mediaPoints;
			return "Playing " + media.toString();
		} else {
			return "Buy more points: Requires " + mediaPoints + " points, you have " + pointsRemaining + " points";
		}
	}
}