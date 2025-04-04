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
                    if(words.isEmpty()){
                        System.out.println("No words to practice yet.");
                        break;
                    }
                    System.out.println("You chose to practice all words");
                    for(Word word : words) {
                        System.out.println("Polish: " + word.getPolish());
                        System.out.println("Type the English translation: ");
                        String answer = scanner.nextLine().trim();

                        if(answer.equalsIgnoreCase(word.getEnglish())) {
                            word.markAsKnown();
                            System.out.println("Correct!");
                        } else {
                            System.out.println("Incorrect. Correct answer: " + word.getEnglish());
                        }
                        System.out.println();

                    }
                    System.out.println("Practice session finished. Press Enter to return to menu...");
                    scanner.nextLine(); // wait before returning to menu
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
