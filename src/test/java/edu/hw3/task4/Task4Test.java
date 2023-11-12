package edu.hw3.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task4Test {

    @Test
    @DisplayName("Task 4")
    void test() {
        int[] input = new int[] {2, 12, 16, 999, 547};
        String[] output = new String[] {"II", "XII", "XVI", "CMXCIX", "DXLVII"};

        for (int i = 0; i < input.length; i++) {
            assertThat(Task4.convertToRoman(input[i])).isEqualTo(output[i]);
        }
    }

}
