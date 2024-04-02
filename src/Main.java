import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random();
        final Scanner scanner = new Scanner(System.in);
        final String[] words = {"porto", "destiny", "olivie", "beata"};
        final String wordToGuess = selectWord(words, random);
        final String hiddenWord = generateHiddenWord(wordToGuess);
        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + hiddenWord);

        int MAX_INCORRECT_GUESSES = 6;
        int incorrectGuesses = 0;
        while (incorrectGuesses < MAX_INCORRECT_GUESSES && hiddenWord.contains("_")) {
            System.out.println("Enter a letter: ");
            char guess = scanLetter(scanner);

            if (wordToGuess.contains(String.valueOf(guess))) {

            } else {
                incorrectGuesses++;
                System.out.println("Incorrect guess! Number of remaining guesses: " + );
            }
        }
    }

    public static char scanLetter(Scanner scanner) {
        char guess;

        try {
            String line = scanner.nextLine();
            if (line.length() != 1) {
                throw new Exception("Line lenght is not 1. Please enter a single letter");
            }

            guess = line.charAt(0);
            if (!Character.isLetter(guess)) {
                throw new Exception("Character is not a letter Please enter letter");
            }


        } catch (Exception e) {
            System.out.println("Invalid input: "e.getMessage());
        }
        return guess;
    }



    public static String selectWord(String[] words, Random random) {
        //metoda vrací String, který stejně pomlček jako písmen ve slově
        final String wordToGuess = words[random.nextInt(words.length)];
        return "_".repeat(wordToGuess.length());
    }

    public static String generateHiddenWord(String word) {
        return "_".repeat(word.length());
    }
}