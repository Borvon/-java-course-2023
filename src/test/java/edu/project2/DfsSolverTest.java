package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DfsSolverTest {

    @Test
    @DisplayName("SolverTest")
    void test() {
        int height = 10;
        int width = 10;

        int[][] rightBorders =
            {
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 1, 0, 1, 0, 1}
            };

        int[][] lowerBorders =
            {
                {0, 1, 0, 0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            };

        int[][] expectingSolution =
            {
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 2, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 2, 2, 2, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            };

        Maze maze = new Maze(height, width, rightBorders, lowerBorders);
        Solver solver = new DfsSolver();
        var solution = solver.solve(maze);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (expectingSolution[i][j] == 2) {
                    assertThat(solution[i][j]).isEqualTo(2);
                } else {
                    assertThat(solution[i][j]).isNotEqualTo(2);
                }
            }
        }
    }
}
