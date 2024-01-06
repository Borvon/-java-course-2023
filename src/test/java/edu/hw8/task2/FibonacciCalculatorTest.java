package edu.hw8.task2;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicIntegerArray;
import static org.assertj.core.api.Assertions.assertThat;

class FibonacciCalculatorTest {

    @Test
    void test() {
        ThreadPool threadPool = new FixedThreadPool(5);
        threadPool.start();

        AtomicIntegerArray result = new AtomicIntegerArray(new int[5]);

        threadPool.execute(() -> result.set(0, FibonacciCalculator.calculateFor(5)));
        threadPool.execute(() -> result.set(1, FibonacciCalculator.calculateFor(6)));
        threadPool.execute(() -> result.set(2, FibonacciCalculator.calculateFor(7)));
        threadPool.execute(() -> result.set(3, FibonacciCalculator.calculateFor(8)));
        threadPool.execute(() -> result.set(4, FibonacciCalculator.calculateFor(9)));

        int[] expected = {5, 8, 13, 21, 34};
        for (int i = 0; i < 5; i++) {
            while (result.get(i) == 0) ; //Выглядит так, как будто можно было иначе, но ничего умнее не придумал
            assertThat(result.get(i)).isEqualTo(expected[i]);
        }
    }
}
