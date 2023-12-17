package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    @DisplayName("Task 7 Check 1")
    void check1() {
        List<String> input = List.of("1", "101", "11", "110", "1100000", "1101", "1111");
        List<Boolean> output = List.of(false, false, false, true, true, true, false);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task7.check1(input.get(i))).isEqualTo(output.get(i));
        }
    }

    @Test
    @DisplayName("Task 7 Check 2")
    void check2() {
        List<String> input = List.of("1", "101", "11", "110", "1100000", "1101", "1111");
        List<Boolean> output = List.of(true, true, true, false, false, true, true);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task7.check2(input.get(i))).isEqualTo(output.get(i));
        }
    }

    @Test
    @DisplayName("Task 7 Check 3")
    void check3() {
        List<String> input = List.of("1", "101", "11", "110", "1100000", "1101", "1111");
        List<Boolean> output = List.of(true, true, true, true, false, false, false);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task7.check3(input.get(i))).isEqualTo(output.get(i));
        }
    }
}
