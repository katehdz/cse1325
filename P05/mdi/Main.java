pacakage mdi;

import moes.Moes;
import customer.Student;
import product.Media;
import java.util.Scanner;


public class Main {
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;

	public main (){
		moes = new Moes();
		menu = new Menu();
		output = " ";
		running = true;

		// Add menu items
        menu.addMenuItem(new MenuItem("0] Exit\n", this::endApp));
        menu.addMenuItem(new MenuItem("1] Play Media", this::playMedia));
        menu.addMenuItem(new MenuItem("2] List Media", this::listMedia));
        menu.addMenuItem(new MenuItem("3] List Available Points", this::listAvailablePoints));
        menu.addMenuItem(new MenuItem("4] Buy Points", this::buyPoints));
        menu.addMenuItem(new MenuItem("5] Add Media\n", this::addMedia));
        menu.addMenuItem(new MenuItem("6] List All Students", this::listStudents));
        menu.addMenuItem(new MenuItem("7] Add a Student", this::addStudent));
	}

	private void mdi(){

	}

	private void endApp(){
		running = false;
		System.out.println("Exiting...");
	}

	private void addStudent() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Student name? ");
		String name= scanner.nextLine();

		System.out.print("Student ID? ");
		int ID = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Student email? ");
		String email = scanner.nextLine();

		System.out.print("(a)lacarte or (u)nlimited? ");
		char accountType = scanner.next().charAt(0);

		boolen unlimited = (accountType == 'u' || accountType == 'U');

		Student student = new Student(name, id, email, unlimited);

		moes.addStudent(student);

		output= "Added student + " student.toString();
		System.out.println(output);
	}

    priavte void listStudents(){
    	output = moes.getStudentList();
    	System.out.println(output);
    }

    private void addMedia(){

    }

    private void listMedia(){

    }

    private void playMedia(){

    }


    private void listAvailablePoints(){

    }

    private void buyPoints(){

    }

    public static void main (String[] args){

    }
}




