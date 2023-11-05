package edu.project2;

import java.util.Random;

public class EllersGenerator implements Generator {

    private final int rightBordersFreq = 3;
    private final int lowerBordersFreq = 2;

    private int counter;

    private static final Random rand = new Random(1);

    @Override
    public Maze generate(int height, int width) {
        int[][] cells = new int[height][width];
        int[][] rightBorders = new int[height][width];
        int[][] lowerBorders = new int[height][width];

        counter = 1;
        for (int i = 0; i < height; i++) {
            assignGroups(i, cells, lowerBorders, width);
            addRightBorders(cells[i], rightBorders[i]);
            addLowerBorders(cells[i], lowerBorders[i]);
        }

        transformLastString(width, cells[height - 1], rightBorders[height - 1], lowerBorders[height - 1]);

        return new Maze(height, width, rightBorders, lowerBorders);
    }

    private void assignGroups(int i, int[][] cells, int[][] lowerBorders, int width) {
        if (i != 0) {
            for (int j = 0; j < width; j++) {
                if (lowerBorders[i - 1][j] == 0) {
                    cells[i][j] = cells[i - 1][j];
                }
            }
        }

        for (int j = 0; j < width; j++) {
            if (cells[i][j] == 0) {
                cells[i][j] = counter++;
            }
        }
    }

    private void addRightBorders(int[] cells, int[] rightBorders) {
        for (int i = 0; i < cells.length; i++) {

            if (i + 1 < cells.length) {
                if (cells[i] == cells[i + 1]) {
                    rightBorders[i] = 1;
                } else if (rand.nextInt() % rightBordersFreq == 0) {
                    rightBorders[i] = 1;
                } else if (i + 1 < cells.length) {
                    mergeGroups(cells, cells[i], cells[i + 1]);
                }
            } else {
                rightBorders[i] = 1;
            }
        }
    }

    private void mergeGroups(int[] cells, int newGroup, int targetGroup) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == targetGroup) {
                cells[i] = newGroup;
            }
        }
    }

    private void addLowerBorders(int[] cells, int[] lowerBorders) {
        boolean hasDoor = false;

        for (int i = 0; i < cells.length; i++) {
            if ((hasDoor || i + 1 < cells.length && cells[i] == cells[i + 1])
                && (rand.nextInt() % lowerBordersFreq == 0)) {
                lowerBorders[i] = 1;
            } else {
                hasDoor = true;
            }
            if (i + 1 < cells.length && cells[i] != cells[i + 1]) {
                hasDoor = false;
            }
        }
    }

    private void transformLastString(int width, int[] cells, int[] rightBorders, int[] lowerBorders) {
        for (int i = 0; i < width - 1; i++) {
            lowerBorders[i] = 1;

            if (cells[i] != cells[i + 1]) {
                rightBorders[i] = 0;
                mergeGroups(cells, cells[i], cells[i + 1]);
            }
        }
        lowerBorders[width - 1] = 0;
    }
}
