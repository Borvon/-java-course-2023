package edu.hw7.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FactorialCalculatorTest {

    @Test
    void test() {
        assertThat(FactorialCalculator.calculate(4)).isEqualTo(24);
        assertThat(FactorialCalculator.calculate(5)).isEqualTo(120);
        assertThat(FactorialCalculator.calculate(6)).isEqualTo(720);
    }
}
