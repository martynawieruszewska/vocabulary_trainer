import java.util.*;      // Imports all utility classes, like ArrayList, Scanner, List, Collections
import java.io.*;        // Imports classes for file input/output like FileReader, FileWriter, BufferedReader, PrintWriter

public class vocabulary_trainer {

    static final String FILE_NAME = "vocabulary.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Word> words = new ArrayList<>();

        //Load words from file on startup
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Word w = Word.fromFileString(line);
                if (w != null) words.add(w);
            }
            System.out.println("Loaded " + words.size() + " words from file.");
        } catch (IOException e) {
            System.out.println("No saved vocabulary found. Starting fresh.");
        }

        while (true) {
            System.out.println("VOCABULARY TRAINER");
            System.out.println("(1) Add new words");
            System.out.println("(2) Practice all words");
            System.out.println("(3) Practice unknown words only");
            System.out.println("(0) Exit");
            System.out.print("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    while (true) {
                        System.out.println("Enter definition (leave empty to return):");
                        String definition = scanner.nextLine().trim();
                        if (definition.isEmpty()) break;

                        System.out.println("Enter English translation:");
                        String english = scanner.nextLine().trim();

                        Word newWord = new Word(definition, english);
                        words.add(newWord);
                        saveAllWords(words);
                        System.out.println("Added: " + newWord);
                    }
                    break;

                case "2":
                    if (words.isEmpty()) {
                        System.out.println("No words to practice yet.");
                        break;
                    }

                    List<Word> shuffledAll = new ArrayList<>(words);
                    Collections.shuffle(shuffledAll); //  Random order

                    for (Word word : shuffledAll) {
                        System.out.println("Definition: " + word.getDefinition());
                        System.out.print("Type the English translation: ");
                        String answer = scanner.nextLine().trim();

                        if (answer.equalsIgnoreCase(word.getEnglish())) {
                            if (!word.isKnown()) {
                                word.markAsKnown();
                                saveAllWords(words);
                            }
                            System.out.println("Correct!");
                        } else {
                            if (word.isKnown()) {
                                word.setKnown(false);
                                saveAllWords(words);
                            }
                            System.out.println("Incorrect. Correct: " + word.getEnglish());
                        }
                        System.out.println();
                    }

                    System.out.println("Practice session finished. Press Enter to return.");
                    scanner.nextLine();
                    break;

                case "3":
                    List<Word> unknown = new ArrayList<>();
                    for (Word w : words) {
                        if (!w.isKnown()) unknown.add(w);
                    }

                    if (unknown.isEmpty()) {
                        System.out.println("All words are known!");
                        break;
                    }

                    Collections.shuffle(unknown);

                    for (Word word : unknown) {
                        System.out.println("Definition: " + word.getDefinition());
                        System.out.print("Type the English translation: ");
                        String answer = scanner.nextLine().trim();

                        if (answer.equalsIgnoreCase(word.getEnglish())) {
                            word.markAsKnown();
                            saveAllWords(words);
                            System.out.println("Correct!");
                        } else {
                            word.setKnown(false); // redundant here but ensures consistency
                            saveAllWords(words);
                            System.out.println("Incorrect. Correct: " + word.getEnglish());
                        }
                        System.out.println();
                    }

                    System.out.println("Practice session finished. Press Enter to return.");
                    scanner.nextLine();
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try 1, 2, 3 or 0.");
            }
        }
    }

    // Save all words to file (overwrite mode)
    private static void saveAllWords(List<Word> words) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Word w : words) {
                writer.println(w.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving words to file.");
        }
    }
}