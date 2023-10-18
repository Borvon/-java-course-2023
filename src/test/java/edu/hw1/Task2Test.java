package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Задание 2")
    void test() {
        // given
        int[] inputValues = new int[] {4666, 544, 0};

        int[] outputValues = new int[] {4, 3, 1};

        for (int i = 0; i < inputValues.length; i++) {
            // when
            int result = Task2.countDigits(inputValues[i]);

            // then
            assertThat(result).isEqualTo(outputValues[i]);
        }

    }

}
