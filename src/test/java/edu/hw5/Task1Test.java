package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Task 1")
    void test() {
        List<List<String>> input = List.of(
            List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"),
            List.of("2022-03-12, 13:10 - 2022-03-12, 23:50", "2022-03-31, 21:30 - 2022-04-02, 01:20")
        );
        List<String> output = List.of("3ч 40м", "19ч 15м");

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task1.calculateDuration(input.get(i))).isEqualTo(output.get(i));
        }
    }
}
