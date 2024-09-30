package moes;

import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import product.Media;
import java.util.ArrayList;
import java.util.List;

public class Moes {
	private List<Media> library = new ArrayList<>();
	private List<Student> customers = new ArrayList<>();

	public void addMedia(Media media){
		library.add(media);
	}

	public String getMediaList(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < library.size(); i++){
			Media media = library.get(i);
			sb.append(i).append(") ").append(media.toString()).append("\n");
		}
		return sb.toString();
	}

	public void addStudent(Student student){
		customers.add(student);
	}

	public String getStudentList(){
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < customers.size(); i++){
			Student student = customers.get(i);
			sb.append(i).append(")").append(student.toString()).append("\n");
		}
		return sb.toString();
	}

	public int getPoints(int studentIndex) {
	    if (studentIndex < 0 || studentIndex >= customers.size()) {
	        throw new IndexOutOfBoundsException("Invalid student index");
	    }
	    Account account = customers.get(studentIndex).getAccount();
	    if (account instanceof Alacarte) {
	        return ((Alacarte) account).getPointsRemaining();
	    } else if (account instanceof Unlimited) {
	        return Integer.MAX_VALUE;
	    } else {
	        throw new UnsupportedOperationException("Unknown subclass of Account");
	    }
	}


	public String buyPoints(int studentIndex, int points) {
	    if (studentIndex < 0 || studentIndex >= customers.size()) {
	        throw new IndexOutOfBoundsException("Invalid student index");
	    }
	    Account account = customers.get(studentIndex).getAccount();
	    if (account instanceof Alacarte) {
	        ((Alacarte) account).buyPoints(points);
	        return "Student now has " + ((Alacarte) account).getPointsRemaining() + " points.";
	    } else if (account instanceof Unlimited) {
	        return "Student has an unlimited account, no additional points needed.";
	    } else {
	        throw new UnsupportedOperationException("Unknown subclass of Account");
	    }
	}


	public String playMedia(int studentIndex, int mediaIndex) {
	    if (studentIndex < 0 || studentIndex >= customers.size()) {
	        throw new IndexOutOfBoundsException("Invalid student index");
	    }
	    if (mediaIndex < 0 || mediaIndex >= library.size()) {
	        throw new IndexOutOfBoundsException("Invalid media index");
	    }
	    Student student = customers.get(studentIndex);
	    Media media = library.get(mediaIndex);
	    return student.getAccount().play(media);
	}
}
