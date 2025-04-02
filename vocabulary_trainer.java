import java.util.ArrayList; // Imports the ArrayList class – a resizable list to store objects
import java.util.Scanner;   // Imports the Scanner class – used to read user input from the console

public class vocabulary_trainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object to read user input from the console
        ArrayList<Word> words = new ArrayList<>(); 

        while (true) {
            System.out.println("VOCABULARY TRAINER");
            System.out.println("Choose your option:");
            System.out.println("(1) Add new words");
            System.out.println("(2) Practice all words");
            System.out.println("(3) Practice unknown words only");
            System.out.println("(0) Exit");

            System.out.print("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("You chose to add new words");
                    System.out.println("Press Enter to return to menu...");
                    scanner.nextLine(); // Optional: clear buffer
                    scanner.nextLine(); // Actual wait
                    break;

                case "2":
                    System.out.println("You chose to practice all words");
                    System.out.println("Press Enter to return to menu...");
                    scanner.nextLine(); // Optional: clear buffer
                    scanner.nextLine(); // Actual wait
                    break;

                case "3":
                    System.out.println("You chose to practice unknown words");
                    System.out.println("Press Enter to return to menu...");
                    scanner.nextLine(); // Optional: clear buffer
                    scanner.nextLine(); // Actual wait
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    scanner.close(); // Closes the scanner
                    return; // Exits the program

                default:
                    System.out.println("Invalid option. Please enter 1, 2, 3 or 0.");
            }
        }
    }
}
