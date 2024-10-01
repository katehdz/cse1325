package mdi;

import moes.Moes;
import customer.Student;
import product.Media;
import java.util.Scanner;


public class Main {
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;
	private Scanner scanner;

	public Main (){
		this.moes = new Moes();
		this.menu = new Menu();
		this.output = " ";
		this.running = true;
		scanner = new Scanner(System.in);

		// Add menu items
        menu.addMenuItem(new MenuItem("Exit\n", () -> endApp()));
	    menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
	    menu.addMenuItem(new MenuItem("List Media", () -> listMedia()));
	    menu.addMenuItem(new MenuItem("List Available Points", () -> listAvailablePoints()));
	    menu.addMenuItem(new MenuItem("Buy Points", () -> buyPoints()));
	    menu.addMenuItem(new MenuItem("Add Media\n", () -> addMedia()));
	    menu.addMenuItem(new MenuItem("List All Students", () -> listStudents()));
	    menu.addMenuItem(new MenuItem("Add a Student", () -> addStudent()));

	}

	private void mdi(){
		while (running){
			System.out.println("***Welcome to Mavs Online Entertainment System***\n                   Main Menu ");
			System.out.println(menu.toString());
			output = " ";
			System.out.print("Selection? ");
			if (scanner.hasNextInt()) {
            	int choice = scanner.nextInt();
            	menu.run(choice); 
        	} else {
	            System.out.println("Invalid input, please enter a number.");
	            scanner.next(); 
		}
	}

	private void endApp(){
		running = false;
		System.out.println("Exiting...");
	}

	private void addStudent() {
	scanner.nextLine();

    System.out.print("Student name? ");
    String name = scanner.nextLine();
    

    System.out.print("Student ID? ");
    int id = scanner.nextInt();
    scanner.nextLine();  
    

    System.out.print("Student email? ");
    String email = scanner.nextLine();
    

    System.out.print("(a)lacarte or (u)nlimited? ");
    char accountType = scanner.next().charAt(0);
    

    boolean unlimited = (accountType == 'u' || accountType == 'U');
    Student student = new Student(name, id, email, unlimited);

    moes.addStudent(student);

    output = "\nAdded student " + student.toString();
    System.out.println(output);
}


    private void listStudents(){
    	output = moes.getStudentList();
    	System.out.println(output);
    }

    private void addMedia(){
    	scanner.nextLine();
    
	    System.out.print("Title? ");
	    String title = scanner.nextLine();

	    System.out.print("URL? ");
	    String url = scanner.nextLine();

	    System.out.print("Points? ");
	    int points = scanner.nextInt();

	    Media media = new Media(title, url, points);

	    moes.addMedia(media);

	    output = "Added media: " + media.toString();
	    System.out.println(output);
    }

    private void listMedia(){
    	output = moes.getMediaList();
    	System.out.println(output);
    }

    private void playMedia(){

	    System.out.println("Student number? ");
	    System.out.println(moes.getStudentList());
	    int studentIndex = scanner.nextInt();
	  	

	    System.out.println("Media number? ");
	    System.out.println(moes.getMediaList());
	    int mediaIndex = scanner.nextInt();

	    output = moes.playMedia(studentIndex, mediaIndex);
	    System.out.println(output);
    }


    private void listAvailablePoints(){

	    System.out.println("Student number? ");
	    System.out.println(moes.getStudentList());
	    int studentIndex = scanner.nextInt();

	    int points = moes.getPoints(studentIndex);
	    System.out.println("Student has " + points + " points.");
    }

    private void buyPoints(){
	
	    System.out.println("Student number? \n");
	    System.out.println(moes.getStudentList());
	    int studentIndex = scanner.nextInt();

	    int currentPoints = moes.getPoints(studentIndex);
	    System.out.println("Current points: " + currentPoints);

	    System.out.print("Buy how many points? ");
	    int pointsToBuy = scanner.nextInt();

	    if (pointsToBuy < 0) {
	        System.out.println("Cannot purchase negative points.");
	        return;
	    }

	    output = moes.buyPoints(studentIndex, pointsToBuy);
	    System.out.println(output);
	    }

    public static void main (String[] args){
    	Main app = new Main ();
    	app.mdi();
    }
}




