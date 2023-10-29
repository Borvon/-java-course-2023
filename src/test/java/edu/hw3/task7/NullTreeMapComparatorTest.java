package edu.hw3.task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

class NullTreeMapComparatorTest {

    @Test
    @DisplayName("Task 7")
    void test() {
        TreeMap<String, String> tree = new TreeMap<>(new NullTreeMapComparator());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();

        tree.put("abc", "test");
        tree.put(null, "test");
        tree.put("cba", "test");
        assertThat(tree.keySet().toString()).isEqualTo("[null, abc, cba]");
    }

}
