package mdi;

import moes.Moes;
import product.Media;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import customer.Student;
import java.util.Scanner;
import java.io.*;


public class Main {
	private static final String extension = ".moes";
	private static final String magicCookie = "MOES FILE";
	private static final String fileVersion = "1.0";
	private String filename;
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
		this.filename = "";

		// Add menu items
        menu.addMenuItem(new MenuItem("Exit\n", () -> endApp()));
	    menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
	    menu.addMenuItem(new MenuItem("List Media", () -> listMedia()));
	    menu.addMenuItem(new MenuItem("List Available Points", () -> listAvailablePoints()));
	    menu.addMenuItem(new MenuItem("Buy Points", () -> buyPoints()));
	    menu.addMenuItem(new MenuItem("Add Media\n", () -> addMedia()));
	    menu.addMenuItem(new MenuItem("List All Students", () -> listStudents()));
	    menu.addMenuItem(new MenuItem("Add a Student\n", () -> addStudent()));
	    menu.addMenuItem(new MenuItem("New MOES File", () -> newMoes()));
	    menu.addMenuItem(new MenuItem("Open", () -> open()));
        menu.addMenuItem(new MenuItem("Save to File", () -> save()));
        menu.addMenuItem(new MenuItem("Save As New File", () -> saveAs()));
        

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
	}

	private void endApp(){
		running = false;
		System.out.println("Exiting...");
	}

	private void newMoes() {
        this.moes = new Moes();
        this.filename = "";
        System.out.println("Started a new MOES session.");
    }

    private void save() {
        if (filename.isEmpty()) {
            System.out.println("No filename specified. Use 'Save As' instead.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(magicCookie);
            writer.newLine();
            writer.write(fileVersion);
            writer.newLine();
            moes.save(writer);
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void saveAs() {
        System.out.println("Current filename: " + (filename.isEmpty() ? "None" : filename));
        System.out.print("Enter new filename: ");
        scanner.nextLine();
        String newFilename = scanner.nextLine();
        if (newFilename.isEmpty()) {
            return;
        }
        if (!newFilename.endsWith(extension)) {
            newFilename += extension;
        }
        filename = newFilename;
        save();
    }

    private void open() {
        System.out.println("Current filename: " + (filename.isEmpty() ? "None" : filename));
        System.out.print("Enter filename to open: ");
        scanner.nextLine();
        String newFilename = scanner.nextLine();
        if (newFilename.isEmpty()) {
            return;
        }
        if (!newFilename.endsWith(extension)) {
            newFilename += extension;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(newFilename))) {
            String fileCookie = reader.readLine();
            if (!magicCookie.equals(fileCookie)) {
                throw new IOException("Invalid file format.");
            }
            String version = reader.readLine();
            if (!fileVersion.equals(version)) {
                throw new IOException("Unsupported file version.");
            }
            Moes newMoes = new Moes(reader);
            moes = newMoes;
            filename = newFilename;
            System.out.println("File " + filename + " loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }


	private void addStudent() {
	scanner.nextLine();

    System.out.print("Student name? ");
    String name = scanner.nextLine();
    if (name.isEmpty()){
    	return;
    }
    

    System.out.print("Student ID? ");
    String idInput = scanner.nextLine();
    if(idInput.isEmpty()){
    	return;
    }
    
    int id= Integer.parseInt(idInput);

    System.out.print("Student email? ");
    String email = scanner.nextLine();
    if(email.isEmpty()){
    	return;
    }
    

    System.out.print("(a)lacarte or (u)nlimited? ");
    String accountTypeInput = scanner.nextLine();
    if (accountTypeInput.isEmpty()){
    	return;
    }
    char accountType = accountTypeInput.charAt(0);
    

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
	    if (title.isEmpty()){
	    	return;
	    }

	    System.out.print("URL? ");
	    String url = scanner.nextLine();
	    if (url.isEmpty()){
	    	return;
	    }

	    System.out.print("Points? ");
	    String pointsInput = scanner.nextLine();
	    if (pointsInput.isEmpty()){
	    	return;
	    }
	    int points = Integer.parseInt(pointsInput);

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
