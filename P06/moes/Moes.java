package moes;

import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import product.Media;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Moes {
	private List<Media> library = new ArrayList<>();
	private List<Student> customers = new ArrayList<>();

	public Moes(){}

	public Moes(BufferedReader br) throws IOException {
    int mediaCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < mediaCount; i++) {
        library.add(new Media(br));
    }
	int customerCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < customerCount; i++) {
        String name = br.readLine();
        int id = Integer.parseInt(br.readLine());
        String email = br.readLine();
        boolean isUnlimited = Boolean.parseBoolean(br.readLine());

        Student student;
        if (isUnlimited) {
            student = new Student(name, id, email, true);
        } else {
            student = new Student(name, id, email, false);
            int pointsRemaining = Integer.parseInt(br.readLine());
            ((Alacarte) student.getAccount()).buyPoints(pointsRemaining);
        }

            customers.add(student);
    }
}

	public void save(BufferedWriter bw) throws IOException {
       
        bw.write(library.size() + "\n");
        for (Media media : library) {
            media.save(bw);  
        }

        bw.write(customers.size() + "\n");
        for (Student student : customers) {
            student.save(bw);  
            Account account = student.getAccount();
            bw.write((account instanceof Unlimited) + "\n");  

            if (account instanceof Alacarte) {
                bw.write(((Alacarte) account).getPointsRemaining() + "\n");  
            }
        }
    }

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