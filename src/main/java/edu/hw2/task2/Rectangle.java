package edu.hw2.task2;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle() {
        width = 0;
        height = 0;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle setWidth(int width) {
        return new Rectangle(width, height);
    }

    Rectangle setHeight(int height) {
        return new Rectangle(width, height);
    }

    double area() {
        return width * height;
    }
}
