package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] arrNested, int[] arr) {

        if (arrNested == null || arr == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (arrNested.length == 0 || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int min1 = getMin(arrNested);
        int min2 = getMin(arr);

        int max1 = getMax(arrNested);
        int max2 = getMax(arr);

        return min1 > min2 && max1 < max2;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
