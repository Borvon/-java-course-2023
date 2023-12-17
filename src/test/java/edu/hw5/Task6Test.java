package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class Task6Test {

    @Test
    @DisplayName("Task 6")
    void test() {
        List<List<String>> input = List.of(List.of("А123ВЕ777", "23ВЕ"),
            List.of("О777ОО177", "177"),
            List.of("123АВЕ777", "32АВЕ"),
            List.of("А123ВГ77", "false"),
            List.of("А123ВЕ777", "А123ВЕ777")
        );
        List<Boolean> output = List.of(true, true, false, false, true);

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task6.isSubstring(input.get(i).get(0), input.get(i).get(1))).isEqualTo(output.get(i));
        }
    }

}
