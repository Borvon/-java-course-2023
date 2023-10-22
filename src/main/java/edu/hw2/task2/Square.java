package edu.hw2.task2;

public class Square extends Rectangle {

    @Override
    int setWidth(int width) {
        super.setHeight(width);
        super.setWidth(width);
        return 1;
    }

    @Override
    int  setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
        return 1;
    }
}
