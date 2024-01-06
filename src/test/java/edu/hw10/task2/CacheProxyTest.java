package edu.hw10.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CacheProxyTest {

    @Test
    void test() {
        FibCalculator c = new SimpleFibCalculator();
        FibCalculator proxy = CacheProxy.create(c, FibCalculator.class);

        assertThat(proxy.fib(10)).isEqualTo(55);
        assertThat(proxy.fib(1)).isEqualTo(1);
        assertThat(proxy.fib(11)).isEqualTo(89);
        assertThat(proxy.fib(12)).isEqualTo(144);
    }
}
