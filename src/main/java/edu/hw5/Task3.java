package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {

    private Task3() {

    }

    public static Optional<LocalDate> parseDate(String input) {
        Optional<LocalDate> result = parseYMD(input);

        if (result.isEmpty()) {
            result = parseShortYMD(input);
        }

        if (result.isEmpty()) {
            result = parseSlash(input);
        }

        if (result.isEmpty()) {
            result = parseString(input);
        }

        if (result.isEmpty()) {
            result = parseNDaysAgo(input);
        }

        return result;
    }

    private static Optional<LocalDate> parseYMD(String input) {
        String format = "\\d{4}-(0[1-9]|1[0-2])-([0-2][0-9]|3[0-1])";

        if (input.matches(format)) {

            String[] splitted = input.split("-");

            int year = Integer.parseInt(splitted[0]);
            int month = Integer.parseInt(splitted[1]);
            int day = Integer.parseInt(splitted[2]);

            return Optional.of(LocalDate.of(year, month, day));

        } else {
            return Optional.empty();
        }
    }

    private static Optional<LocalDate> parseShortYMD(String input) {

        String format = "\\d{4}-([1-9]|1[0-2])-([1-9]|[1-2][0-9]|3[0-1])";

        if (input.matches(format)) {

            String[] splitted = input.split("-");

            int year = Integer.parseInt(splitted[0]);
            int month = Integer.parseInt(splitted[1]);
            int day = Integer.parseInt(splitted[2]);

            return Optional.of(LocalDate.of(year, month, day));

        } else {
            return Optional.empty();
        }
    }

    private static Optional<LocalDate> parseSlash(String input) {
        String format = "([1-9]|[1-2][0-9]|3[0-1])/([1-9]|1[0-2])/(\\d{4}|\\d{2})";

        if (input.matches(format)) {

            String[] splitted = input.split("/");

            int year =
                (splitted[2].length() == 2) ? Integer.parseInt("20" + splitted[2]) : Integer.parseInt(splitted[2]);
            int month = Integer.parseInt(splitted[1]);
            int day = Integer.parseInt(splitted[0]);

            return Optional.of(LocalDate.of(year, month, day));

        } else {
            return Optional.empty();
        }
    }

    private static Optional<LocalDate> parseString(String input) {
        return switch (input) {
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default -> Optional.empty();
        };
    }

    private static Optional<LocalDate> parseNDaysAgo(String input) {
        String format = "1 day ago|\\d+ days ago";

        if (input.matches(format)) {
            int days = 0;

            for (int i = 1; i < input.length(); i++) {

                if (!(input.substring(0, i).matches("\\d+"))) {
                    days = Integer.parseInt(input.substring(0, i - 1));
                    break;
                }

            }
            return Optional.of(LocalDate.now().minusDays(days));

        } else {
            return Optional.empty();
        }
    }
}
