package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConnectionTest {
    @Test
    @DisplayName("StableConnection test")
    void stableConnectionTest() throws Exception {
        try (var connection = new StableConnection()) {
            for (int i = 0; i < 10; i++) {
                assertAll(() -> connection.execute("command"));
            }
        }
    }

    @Test
    @DisplayName("FaultyConnection test")
    void faultyConnectionTest() throws Exception {
        try (var connection = new FaultyConnection()) {
            for (int i = 0; i < 10; i++) {
                if (i % 4 == 0) {
                    assertThrows(
                        ConnectionException.class,
                        () -> connection.execute("command"),
                        "ConnectionException was expected"
                    );
                } else {
                    assertAll(() -> connection.execute("command"));
                }
            }
        }
    }
}

