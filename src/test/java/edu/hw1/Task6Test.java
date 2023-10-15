package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    @DisplayName("Задание 6")
    void test() {
        // given
        int[] inputValues = new int[] {3524, 6621, 6554, 1234};

        int[] outputValues = new int[] {3, 5, 4, 3};

        for (int i = 0; i < inputValues.length; i++) {
            // when
            int result = Task6.countK(inputValues[i]);

            // then
            assertThat(result).isEqualTo(outputValues[i]);
        }

    }

}
