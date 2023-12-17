package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    @DisplayName("Task 3")
    void test() {
        List<String> input = List.of("2020-10-10",
            "2020-12-2",
            "1/3/1976",
            "1/3/20",
            "tomorrow",
            "today",
            "yesterday",
            "1 day ago",
            "2234 days ago"
        );
        List<Optional<LocalDate>> output = List.of(
            Optional.of(LocalDate.of(2020, 10, 10)),
            Optional.of(LocalDate.of(2020, 12, 2)),
            Optional.of(LocalDate.of(1976, 3, 1)),
            Optional.of(LocalDate.of(2020, 3, 1)),
            Optional.of(LocalDate.now().plusDays(1)),
            Optional.of(LocalDate.now()),
            Optional.of(LocalDate.now().minusDays(1)),
            Optional.of(LocalDate.now().minusDays(1)),
            Optional.of(LocalDate.now().minusDays(2234))
        );

        for (int i = 0; i < input.size(); i++) {
            assertThat(Task3.parseDate(input.get(i))).isEqualTo(output.get(i));
        }
    }
}
