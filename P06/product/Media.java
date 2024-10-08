package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
	public Media(String title, String url, int points){
		this.title= title;
		this.url=url;
		this.points=points;
	}

	/**
     * Constructs a Media object from a BufferedReader.
     * Reads title, URL, and points in order.
     *
     * @param br the BufferedReader to read the media data from
     * @throws IOException if an I/O error occurs
     */
	public Media(BufferedReader br) throws IOException {
        this.title = br.readLine();
        this.url = br.readLine();  // Fixed the typo here
        this.points = Integer.parseInt(br.readLine());
    }

	/**
     * Saves the Media object data to a BufferedWriter.
     *
     * @param bw the BufferedWriter to write the media data to
     * @throws IOException if an I/O error occurs
     */
	public void save (BufferedWriter bw) throws IOException{
		bw.write(title + "\n");
		bw.write(url + "\n");
		bw.write(Integer.toString(points) + "\n");
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