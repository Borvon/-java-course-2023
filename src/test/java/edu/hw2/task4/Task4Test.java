package edu.hw2.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    @Test
    @DisplayName("Task4 test")
    void testCallingInfo() {
        assertThat(Task4.callingInfo().className()).isEqualTo("edu.hw2.task4.Task4Test");
        assertThat(Task4.callingInfo().methodName()).isEqualTo("testCallingInfo");
    }

    @Test
    @DisplayName("Another Task4 test")
    void anotherTestCallingInfo() {
        assertThat(Task4.callingInfo().className()).isEqualTo("edu.hw2.task4.Task4Test");
        assertThat(Task4.callingInfo().methodName()).isEqualTo("anotherTestCallingInfo");
    }
}
