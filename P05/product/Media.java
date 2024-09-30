package product;

/**
 * Models a media item with a title, URL, and point value.
 *
 * @author Kaitlynn Hernandez
 * @version 0.2
 * @since 0.2
 */

public class Media {

	private String title;
	private String url;
	private int points;

	/**
     * Constructs a Media with title, URL, and points.
     * 
     * @param title the title of the media
     * @param url the URL of the media
     * @param points the point value of media
     * @since 0.2
     */

	//constructor
	public Media(String title, String url, int points){
		this.title= title;
		this.url=url;
		this.points=points;
	}

	/**
     * Returns the point value of the media.
     * 
     * @return the point value of the media
     * @since 0.2
     */

	public int getPoints(){
		return points;
	}

	/**
     * Returns a string "title (url, points points)".
     * 
     * @return a string representation of the media
     * @since 0.2
     */

	@Override
	public String toString(){
		return title + " (" + url + ", " + points + " points)";
	}
}