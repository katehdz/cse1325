package test;

public class TestMedia {
	public static void main (String[] args){

		Media media = new Media ("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");

		String expected = "The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)";

		String actual = media.toString();

		if (!expected.equals(actual)){
			System.out.println("FAIL: Expected \"" + expected + "\"\nActual: \"" + actual +"\"");
			System.exit(1);
		}
	}
}