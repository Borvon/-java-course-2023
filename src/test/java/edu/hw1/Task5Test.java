package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    @DisplayName("Задание 5")
    void test() {
        // given
        int[] inputValues = new int[] {11211230, 13001120, 23336014, 11, 12};

        boolean[] outputValues = new boolean[] {true, true, true, true, false};

        for (int i = 0; i < inputValues.length; i++) {
            // when
            boolean result = Task5.isPalindromeDescendant(inputValues[i]);

            // then
            assertThat(result).isEqualTo(outputValues[i]);
        }

    }

}
