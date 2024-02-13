import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class wordcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Word Counter!");
        System.out.println("Enter 'text' to input text or 'file' to provide a file:");

        String inputType = scanner.nextLine().trim().toLowerCase();

        switch (inputType) {
            case "text":
                System.out.println("Enter the text:");
                String text = scanner.nextLine();
                countWords(text);
                break;
            case "file":
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                countWordsFromFile(filePath);
                break;
            default:
                System.out.println("Invalid input type. Please enter 'text' or 'file'.");
        }

        scanner.close();
    }

    public static void countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);
    }

    public static void countWordsFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            StringBuilder textBuilder = new StringBuilder();

            while (fileScanner.hasNextLine()) {
                textBuilder.append(fileScanner.nextLine()).append(" ");
            }

            String text = textBuilder.toString();
            countWords(text);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file path and try again.");
        }
    }
}
