package edu.hw5;

public class Task7 {

    private Task7() {
    }

    public static boolean check1(String input) {
        return input.matches("[01]{2}0[01]*");
    }

    public static boolean check2(String input) {
        return input.matches("0|1|0[01]*0|1[01]*1");
    }

    public static boolean check3(String input) {
        return input.matches("[01]{1,3}");
    }
}
