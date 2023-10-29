package edu.hw3.task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class BackwardIteratorTest {

    @Test
    @DisplayName("Task 8")
    void test() {
        Iterator<Integer> back = new BackwardIterator<>(List.of(1, 2, 3));

        assertThat(back.hasNext()).isTrue();
        assertThat(back.next()).isEqualTo(3);
        assertThat(back.hasNext()).isTrue();
        assertThat(back.next()).isEqualTo(2);
        assertThat(back.hasNext()).isTrue();
        assertThat(back.next()).isEqualTo(1);
        assertThat(back.hasNext()).isFalse();
    }

}
