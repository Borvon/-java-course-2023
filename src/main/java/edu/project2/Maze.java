package edu.project2;

public final class Maze {

    public static void main(String[] args) {

        Generator generator = new EllersGenerator();
        Maze maze = generator.generate(20, 60);

        Renderer renderer = new ConsoleRenderer(maze);
        renderer.render();
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
