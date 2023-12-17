package edu.project2;

public class ConsoleRenderer implements Renderer {

    private final Maze maze;

    public ConsoleRenderer(Maze maze) {
        this.maze = maze;
    }

    @Override
    public String renderWithSolution(int[][] solution) {
        String emptyLine = "   ";
        String line = "───";

        StringBuilder result = new StringBuilder();
        result.append(emptyLine);
        for (int i = 1; i < maze.getWidth() - 1; i++) {
            StringBuilder headBuilder = new StringBuilder(line);

            if (maze.getRightBorders()[0][i - 1] == 1) {
                headBuilder.setCharAt(0, '┬');
            }

            result.append(headBuilder);
        }
        result.append("───┐");

        result.append("\n");
        for (int i = 0; i < maze.getHeight(); i++) {

            result.append("│");
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getRightBorders()[i][j] == 1) {

                    if (solution != null && solution[i][j] == 2) {
                        result.append(" .│");
                    } else {
                        result.append("  │");
                    }
                } else if (solution != null && solution[i][j] == 2) {
                    result.append(" . ");
                } else {
                    result.append(emptyLine);
                }
            }
            result.append("\n");
            result.append((i + 1 == maze.getHeight()) ? "└" : "│");

            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getLowerBorders()[i][j] == 1) {
                    StringBuilder lowerBorderBuilder = new StringBuilder(line);

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

                    result.append(lowerBorderBuilder);

                } else {

                    StringBuilder rightBorderBuilder = new StringBuilder(emptyLine);

                    if (i + 1 < maze.getHeight() && j + 1 < maze.getWidth() && maze.getRightBorders()[i + 1][j] == 1
                        && maze.getLowerBorders()[i][j + 1] == 1) {
                        if (maze.getRightBorders()[i][j] == 1) {
                            rightBorderBuilder.setCharAt(2, '├');
                        } else {
                            rightBorderBuilder.setCharAt(2, '┌');
                        }

                    } else if (i + 1 < maze.getHeight() && maze.getRightBorders()[i][j] == 1
                        && maze.getRightBorders()[i + 1][j] == 1) {
                        rightBorderBuilder.setCharAt(2, '│');
                    } else if (j + 1 != maze.getWidth() && maze.getRightBorders()[i][j] == 1
                        && maze.getLowerBorders()[i][j + 1] == 1) {
                        rightBorderBuilder.setCharAt(2, '└');
                    }

                    result.append(rightBorderBuilder);

                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String render() {
        return renderWithSolution(null);
    }
}
