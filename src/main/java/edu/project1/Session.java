package edu.project1;

public class Session {

    private int currentAttempts;
    private final static int MAX_ATTEMPTS = 5;
    private String word;
    private final StringBuilder guessingProcessStringBuilder = new StringBuilder();
    private int guessedLetters;

    void chooseWord(String word) {
        currentAttempts = 0;
        this.word = word.toLowerCase();
        this.guessingProcessStringBuilder.delete(0, this.guessingProcessStringBuilder.length());
        guessedLetters = 0;

        for (int i = 0; i < word.length(); i++) {
            this.guessingProcessStringBuilder.insert(i, '*');
        }
    }

    TryLetterResponse tryLetter(String input) {
        if (input.length() > 1) {
            return TryLetterResponse.INVALID_INPUT;
        }

        TryLetterResponse response;

        if (currentAttempts >= MAX_ATTEMPTS) {
            response = TryLetterResponse.TOO_MANY_ATTEMPTS;
        } else {
            char checkingLetter = input.toLowerCase().charAt(0);
            if (word.contains(Character.toString(checkingLetter))) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == checkingLetter) {
                        guessingProcessStringBuilder.setCharAt(i, checkingLetter);
                        guessedLetters++;
                    }
                }
                if (guessedLetters == word.length()) {
                    response = TryLetterResponse.WIN;
                } else {
                    response = TryLetterResponse.CORRECT;
                }
            } else {
                currentAttempts++;
                if (currentAttempts != MAX_ATTEMPTS) {
                    response = TryLetterResponse.WRONG;
                } else {
                    response = TryLetterResponse.LOOSE;
                }
            }
        }
        return response;
    }

    String getGuessingString() {
        return guessingProcessStringBuilder.toString();
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getCurrentAttempts() {
        return currentAttempts;
    }

    public enum TryLetterResponse {
        CORRECT, WRONG, WIN, LOOSE, TOO_MANY_ATTEMPTS, INVALID_INPUT;
    }
}
