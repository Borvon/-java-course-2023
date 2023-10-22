package edu.hw2.task2;

public class Rectangle {
    private int width;
    private int height;

    int setWidth(int width) {
        this.width = width;
        return 0;
    }

    int setHeight(int height) {
        this.height = height;
        return 0;
    }

    double area() {
        return width * height;
    }
}
