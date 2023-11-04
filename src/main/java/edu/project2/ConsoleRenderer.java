package edu.project2;

public class ConsoleRenderer implements Renderer {

    private final Maze maze;

    public ConsoleRenderer(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void render() {
        System.out.print("   ");
        for (int i = 1; i < maze.getWidth() - 1; i++) {
            StringBuilder headBuilder = new StringBuilder("───");

            if (maze.getRightBorders()[0][i - 1] == 1) {
                headBuilder.setCharAt(0, '┬');
            }

            System.out.print(headBuilder);
        }
        System.out.print("───┐");

        System.out.println();
        for (int i = 0; i < maze.getHeight(); i++) {

            System.out.print("│");
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getRightBorders()[i][j] == 1) {
                    System.out.print("  │");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
            System.out.print((i + 1 == maze.getHeight()) ? "└" : "│");

            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getLowerBorders()[i][j] == 1) {
                    StringBuilder lowerBorderBuilder = new StringBuilder("───");

                    if (maze.getRightBorders()[i][j] == 1) {

                         lowerBorderBuilder.setCharAt(2, '┘');
                    }

                    if (i + 1 < maze.getHeight()) {
                        if (maze.getRightBorders()[i + 1][j] == 1) {
                            if (maze.getRightBorders()[i][j] == 1) {
                                lowerBorderBuilder.setCharAt(2, '┤');
                            } else {
                                if (j + 1 < maze.getWidth() && maze.getLowerBorders()[i][j + 1] == 1) {
                                    lowerBorderBuilder.setCharAt(2, '┬');
                                } else {
                                    lowerBorderBuilder.setCharAt(2, '┐');
                                }
                            }
                        }
                    }

                    System.out.print(lowerBorderBuilder);

                } else {

                    StringBuilder rightBorderBuilder = new StringBuilder("   ");

                    if (i + 1 < maze.getHeight() && j + 1 < maze.getWidth() && maze.getRightBorders()[i + 1][j] == 1 &&
                        maze.getLowerBorders()[i][j + 1] == 1) {
                        if (maze.getRightBorders()[i][j] == 1) {
                            rightBorderBuilder.setCharAt(2, '├');
                        } else {
                            rightBorderBuilder.setCharAt(2, '┌');
                        }

                    } else if (i + 1 < maze.getHeight() && maze.getRightBorders()[i][j] == 1 &&
                        maze.getRightBorders()[i + 1][j] == 1) {
                        rightBorderBuilder.setCharAt(2, '│');
                    } else if (j + 1 != maze.getWidth() && maze.getRightBorders()[i][j] == 1 &&
                        maze.getLowerBorders()[i][j + 1] == 1) {
                        rightBorderBuilder.setCharAt(2, '└');
                    }

                    System.out.print(rightBorderBuilder);

                }
            }
            System.out.println();
        }
    }
}
