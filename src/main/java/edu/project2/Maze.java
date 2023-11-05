package edu.project2;

public final class Maze {

    public static void main(String[] args) {

        Generator generator = new EllersGenerator();
        Maze maze = generator.generate(18, 50);

        Renderer renderer = new ConsoleRenderer(maze);
        renderer.render();

        Solver solver = new DfsSolver();
        int[][] solution = solver.solve(maze);

        renderer.renderWithSolution(solution);

        /*for (int i=0; i<maze.getHeight(); i++)
        {
            for (int j=0; j< maze.getWidth(); j++)
            {
                System.out.print(solution[i][j]);
            }
            System.out.println();
        }*/
    }

    private final int height;
    private final int width;
    private final int[][] rightBorders;
    private final int[][] lowerBorders;

    public Maze(int height, int width, int[][] rightBorders, int[][] lowerBorders) {
        this.height = height;
        this.width = width;
        this.rightBorders = rightBorders;
        this.lowerBorders = lowerBorders;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getRightBorders() {
        return rightBorders;
    }

    public int[][] getLowerBorders() {
        return lowerBorders;
    }
}
