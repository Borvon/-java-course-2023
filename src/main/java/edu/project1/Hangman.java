package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hangman {

    private final static Logger LOGGER = LogManager.getLogger();

    /*public static void main(String[] args) {
        Hangman hangman = new Hangman();

        hangman.run();
    }*/

    void run() {
        Scanner in = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        dictionary.addWord("Java");
        dictionary.addWord("Test");
        dictionary.addWord("Help");
        dictionary.addWord("Hangman");

        Session session = new Session();
        session.chooseWord(dictionary.getRandomWord());

        LOGGER.info("Start? (yes/no): ");
        String startAnswer;
        startAnswer = in.next();

        while (startAnswer.equals("yes")) {
            LOGGER.info("The word: " + session.getGuessingString());

            LOGGER.info("Guess a letter: ");
            String input = in.next();

            Session.TryLetterResponse response = session.tryLetter(input);

            String textResponse = switch (response) {
                case TOO_MANY_ATTEMPTS -> "Too many attempts";
                case INVALID_INPUT -> "You can guess only one letter.";
                case CORRECT -> "Hit!";
                case WRONG -> "Missed, mistake " + session.getCurrentAttempts() + " out of " + session.getMaxAttempts();
                case WIN -> "You win!";
                case LOOSE -> "You loose!";
            };

            LOGGER.info(textResponse);

            switch (response) {
                case INVALID_INPUT:
                    continue;
                case WIN, LOOSE:
                    LOGGER.info("One more? (yes/no): ");
                    startAnswer = in.next();
                    session.chooseWord(dictionary.getRandomWord());
                    break;
                default:
            }
        }
    }
}
