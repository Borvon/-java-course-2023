package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean isSubstring(String string, String substring) {
        return Pattern.compile(substring).matcher(string).find();
    }

}
