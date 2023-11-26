package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IncrementerTest {

    @Test
    void test() {
        Incrementer incrementer = new Incrementer(5);
        assertAll(incrementer::increment);
        assertThat(incrementer.getCounter().intValue()).isEqualTo(5);
        assertAll(incrementer::increment);
        assertThat(incrementer.getCounter().intValue()).isEqualTo(10);
    }
}
