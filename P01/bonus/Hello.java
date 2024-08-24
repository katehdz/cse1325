import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1;
        System.out.print("Enter your name: ");
        s1 = in.nextLine();
        System.out.println("Hello, " + s1);
    }
}
