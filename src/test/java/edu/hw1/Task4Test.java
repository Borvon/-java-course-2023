package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("Задание 4")
    void test() {
        // given
        String[] inputValues = new String[] {"123456", "hTsii  s aimex dpus rtni.g", "badce"};

        String[] outputValues = new String[] {"214365", "This is a mixed up string.", "abcde"};

        for (int i = 0; i < inputValues.length; i++) {
            // when
            String fixedString = Task4.fixString(inputValues[i]);

            // then
            assertThat(fixedString).isEqualTo(outputValues[i]);
        }

    }

    @Test
    @DisplayName("Задание 4 - null string")
    void nullArgumentTest() {
        assertThrows(NullPointerException.class, () -> {
            Task4.fixString(null);
        }, "NullPointerException was expected");
    }

}
