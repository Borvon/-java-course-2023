package edu.hw3.task4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("MagicNumber")
public class Task4 {

    private Task4() {

    }

    private static final Map<Integer, String> DIGITS_TABLE = new TreeMap<>(Comparator.reverseOrder());

    static {
        DIGITS_TABLE.put(1, "I");
        DIGITS_TABLE.put(4, "IV");
        DIGITS_TABLE.put(5, "V");
        DIGITS_TABLE.put(9, "IX");
        DIGITS_TABLE.put(10, "X");
        DIGITS_TABLE.put(40, "XL");
        DIGITS_TABLE.put(50, "L");
        DIGITS_TABLE.put(90, "XC");
        DIGITS_TABLE.put(100, "C");
        DIGITS_TABLE.put(400, "CD");
        DIGITS_TABLE.put(500, "D");
        DIGITS_TABLE.put(900, "CM");
        DIGITS_TABLE.put(1000, "M");

    }

    public static String convertToRoman(int input) {
        StringBuilder resultBuilder = new StringBuilder();

        int remainder = input;
        Iterator<Integer> keysIterator = DIGITS_TABLE.keySet().iterator();
        int currentKey = keysIterator.next();

        while (remainder > 0) {
            while (remainder < currentKey) {
                currentKey = keysIterator.next();
            }

            remainder -= currentKey;
            resultBuilder.append(DIGITS_TABLE.get(currentKey));
        }
        return resultBuilder.toString();
    }
}
