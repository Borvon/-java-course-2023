package edu.hw2.task3;

import edu.hw1.Task3;
import edu.hw2.task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PopularCommandExecutorTest {
    @Test
    @DisplayName("One attempt test")
    void testOneAttempt() {
        var executor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);

        assertThrows(ConnectionException.class, executor::updatePackages, "ConnectionException was expected");
    }

    @Test
    @DisplayName("Many attempts test")
    void testManyAttempts() {
        var executor = new PopularCommandExecutor(new FaultyConnectionManager(), 100);

        assertAll(executor::updatePackages);
    }
}
