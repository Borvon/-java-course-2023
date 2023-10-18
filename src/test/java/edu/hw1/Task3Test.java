package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    @DisplayName("Задание 3")
    void test() {
        // given
        int[][][] inputValues = new int[][][] {
            {{1, 2, 3, 4}, {0, 6}},
            {{3, 1}, {4, 0}},
            {{9, 9, 8}, {8, 9}},
            {{1, 2, 3, 4}, {2, 3}}
        };

        boolean[] outputValues = new boolean[] {true, true, false, false};

        for (int i = 0; i < inputValues.length; i++) {
            // when
            boolean result = Task3.isNestable(inputValues[i][0], inputValues[i][1]);

            // then
            assertThat(result).isEqualTo(outputValues[i]);
        }

    }

    @Test
    @DisplayName("Задание 3 - пустой массив")
    void illegalArgumentTest() {
        int[] emptyArr = new int[0];
        int[] notEmptyArr = {5};

        assertThrows(IllegalArgumentException.class, () -> {
            Task3.isNestable(emptyArr, emptyArr);
        }, "IllegalArgumentException was expected");

        assertThrows(IllegalArgumentException.class, () -> {
            Task3.isNestable(emptyArr, notEmptyArr);
        }, "IllegalArgumentException was expected");

        assertThrows(IllegalArgumentException.class, () -> {
            Task3.isNestable(notEmptyArr, emptyArr);
        }, "IllegalArgumentException was expected");
    }

    @Test
    @DisplayName("Задание 3 - массив null")
    void nullArgumentTest() {
        int[] notEmptyArr = {5};
        assertThrows(NullPointerException.class, () -> {
            Task3.isNestable(null, null);
        }, "NullPointerException was expected");

        assertThrows(NullPointerException.class, () -> {
            Task3.isNestable(null, notEmptyArr);
        }, "NullPointerException was expected");

        assertThrows(NullPointerException.class, () -> {
            Task3.isNestable(notEmptyArr, null);
        }, "NullPointerException was expected");
    }

}
