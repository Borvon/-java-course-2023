package edu.project2;

public class DfsSolver implements Solver {
    @Override
    public int[][] solve(Maze maze) {
        int[][] solution = new int[maze.getHeight()][maze.getWidth()];

        dfs(maze, solution, 0, 0);

        return solution;
    }

    private boolean dfs(Maze maze, int[][] solution, int startX, int startY) {
        solution[startY][startX] = 1;

        if (startX == maze.getWidth() - 1 && startY == maze.getHeight() - 1) {
            solution[startY][startX] = 2;
            return true;
        }

        if (canGoUp(maze, solution, startX, startY)
            && dfs(maze, solution, startX, startY - 1)) {
            solution[startY][startX] = 2;
            return true;
        }
        if (canGoDown(maze, solution, startX, startY)
            && dfs(maze, solution, startX, startY + 1)) {
            solution[startY][startX] = 2;
            return true;
        }
        if (canGoRight(maze, solution, startX, startY)
            && dfs(maze, solution, startX + 1, startY)) {
            solution[startY][startX] = 2;
            return true;
        }
        if (canGoLeft(maze, solution, startX, startY)
            && dfs(maze, solution, startX - 1, startY)) {
            solution[startY][startX] = 2;
            return true;
        }
        return false;
    }

    private boolean canGoUp(Maze maze, int[][] solution, int startX, int startY) {
        return (startY > 0 && maze.getLowerBorders()[startY - 1][startX] == 0 && solution[startY - 1][startX] == 0);
    }

    private boolean canGoDown(Maze maze, int[][] solution, int startX, int startY) {
        return (startY + 1 < maze.getHeight() && maze.getLowerBorders()[startY][startX] == 0
            && solution[startY + 1][startX] == 0);
    }

    private boolean canGoRight(Maze maze, int[][] solution, int startX, int startY) {
        return (startX + 1 < maze.getWidth() && maze.getRightBorders()[startY][startX] == 0
            && solution[startY][startX + 1] == 0);
    }

    private boolean canGoLeft(Maze maze, int[][] solution, int startX, int startY) {
        return (startX > 0 && maze.getRightBorders()[startY][startX - 1] == 0
            && solution[startY][startX - 1] == 0);
    }
}
