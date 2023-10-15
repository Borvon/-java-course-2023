package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Задание 1")
    void test() {
        // given
        String[] inputValues = new String[] {"01:00", "13:56", "10:60"};

        int[] outputValues = new int[] {60, 836, -1 };

        for (int i = 0; i < inputValues.length; i++) {
            // when
            int result = Task1.minutesToSeconds(inputValues[i]);

            // then
            assertThat(result).isEqualTo(outputValues[i]);
        }

    }

    @Test
    @DisplayName("Задание 1 - null video length")
    void nullArgumentTest() {
        assertThrows(NullPointerException.class, () -> {
            Task1.minutesToSeconds(null);
        }, "NullPointerException was expected");
    }
}
