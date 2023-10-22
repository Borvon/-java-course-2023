package edu.project1;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DictionaryTest {

    @Test
    @DisplayName("Dictionary test")
    void test() {

        Dictionary dictionary = new Dictionary();
        assertThat(dictionary.addWord("Java")).isEqualTo(true);
        assertThat(dictionary.addWord("Test")).isEqualTo(true);
        assertThat(dictionary.addWord("Help")).isEqualTo(true);

        assertThat(dictionary.addWord("II")).isEqualTo(false);
        assertThat(dictionary.getRandomWord()).hasSize(4);
    }

}
