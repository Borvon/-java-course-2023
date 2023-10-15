package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    @DisplayName("Задание 7")
    void test() {
        // given
        int[][] inputValues = new int[][] {{8, 1}, {16, 1}, {17, 2}};

        int[][] outputValues = new int[][] {{1, 4}, {1, 8}, {6, 12}};

        for (int i = 0; i < inputValues.length; i++) {
            // when
            int resultLeft = Task7.rotateLeft(inputValues[i][0], inputValues[i][1]);
            int resultRight = Task7.rotateRight(inputValues[i][0], inputValues[i][1]);

            // then
            assertThat(resultLeft).isEqualTo(outputValues[i][0]);
            assertThat(resultRight).isEqualTo(outputValues[i][1]);
        }

    }
}
