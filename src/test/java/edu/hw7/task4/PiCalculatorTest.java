package edu.hw7.task4;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class PiCalculatorTest {
    static Stream<PiCalculator> factory() {
        return Stream.of(new SingleThreadedPiCalculator(), new MultiThreadedPiCalculator());
    }

    @ParameterizedTest
    @MethodSource("factory")
    void test(PiCalculator calculator) {
        assertThat(calculator.calculate(1_000_000)).isCloseTo(3.14, Offset.offset(0.01));
    }
}
