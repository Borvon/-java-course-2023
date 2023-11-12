package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    @DisplayName("Task 5")
    void test() {
        List<String> input = List.of("А123ВЕ777", "О777ОО177", "123АВЕ777", "А123ВГ77", "А123ВЕ7777");
        List<Boolean> output = List.of(true, true, false, false, false);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task5.validateNumber(input.get(i))).isEqualTo(output.get(i));
        }
    }
}
