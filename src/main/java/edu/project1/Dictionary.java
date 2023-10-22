package edu.project1;

import java.util.LinkedList;
import java.util.List;

public class Dictionary {
    private final static int MIN_LENGTH = 3;
    private final static int MAX_LENGTH = 20;
    List<String> words = new LinkedList<String>();

    public boolean addWord(String word) {
        if (word.length() < MIN_LENGTH || word.length() > MAX_LENGTH) {
            return false;
        } else {
            this.words.add(word);
            return true;
        }
    }

    public String getRandomWord() {
        return words.get((int) (Math.random() * words.size()));
    }
}
