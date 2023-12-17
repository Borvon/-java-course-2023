package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Task2 {

    private static final int REQUIRED_DAY = 13;

    private Task2() {

    }

    public static String getFridays13(int year) {
        final int monthsCount = 12;

        LocalDate date = LocalDate.of(year, 1, REQUIRED_DAY);
        StringBuilder fridays13String = new StringBuilder();

        for (int i = 0; i < monthsCount; i++) {

            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                if (!fridays13String.isEmpty()) {
                    fridays13String.append(", ");
                }

                fridays13String.append(date);
            }

            date = date.plusMonths(1);
        }

        return fridays13String.toString();
    }

    public static String findNearestFriday13(LocalDate date) {
        LocalDate friday = date;

        while (true) {
            friday = friday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (friday.getDayOfMonth() == REQUIRED_DAY) {
                break;
            }
        }
        return friday.toString();
    }
}
