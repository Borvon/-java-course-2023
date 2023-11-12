package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    @Test
    @DisplayName("Task 2")
    void getFridays13() {
        List<Integer> input = List.of(1925, 2024);
        List<String> output = List.of("1925-02-13, 1925-03-13, 1925-11-13", "2024-09-13, 2024-12-13");

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task2.getFridays13(input.get(i))).isEqualTo(output.get(i));
        }
    }

    @Test
    @DisplayName("Task 2")
    void findNearesFriday13() {
        List<LocalDate> input = List.of(LocalDate.of(1925, 2, 14), LocalDate.of(1925, 10, 10));
        List<String> output = List.of("1925-03-13", "1925-11-13");

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task2.findNearestFriday13(input.get(i))).isEqualTo(output.get(i));
        }
    }
}
