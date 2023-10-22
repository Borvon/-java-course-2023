package edu.hw2.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RectangleTest {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        double expectedArea = 200;
        rect.setWidth(20);

        if (rect.setHeight(10) == 1) {
            expectedArea = 100;
        }

        assertThat(rect.area()).isEqualTo(expectedArea);
    }
}
