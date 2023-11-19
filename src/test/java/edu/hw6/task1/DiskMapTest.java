package edu.hw6.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class DiskMapTest {

    @Test
    @DisplayName("DiskMapTest")
    void test() throws IOException {
        Map<String, String> diskMap = new DiskMap(Paths.get(".", "map"));

        diskMap.put("Не", "успеваю");
        diskMap.put("50 минут", "до дедлайна");

        assertThat(diskMap.get("Не")).isEqualTo("успеваю");
        assertThat(diskMap.get("50 минут")).isEqualTo("до дедлайна");
        assertThat(diskMap.size()).isEqualTo(2);

        diskMap.clear();

        assertThat(diskMap.isEmpty()).isTrue();

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("anotherkey", "anothervalue");
        map.put("faster", "please");
        diskMap.putAll(map);
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(diskMap.containsKey("anotherkey")).isTrue();

        diskMap.remove("anotherkey");
        assertThat(diskMap.containsKey("anotherkey")).isFalse();
        diskMap.clear();
    }
}
