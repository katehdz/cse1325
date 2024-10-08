package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Alacarte extends Account {
	private int pointsRemaining=0;

	public Alacarte(){
		super();
	}

	public Alacarte(BufferedReader br) throws IOException {
		super(br);
		this.pointsRemaining = Integer.parseInt(br.readLine());
	}

	@Override
	public void save(BufferedWriter bw) throws IOException{
		super.save(bw);
		bw.write(Integer.toString(pointsRemaining) + "\n");
	}

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