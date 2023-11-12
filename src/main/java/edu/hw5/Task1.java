package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Task1 {

    private Task1() {

    }

    public static String calculateDuration(List<String> intervals) {
        Duration summaryDuration = Duration.ofNanos(0);
        for (String interval : intervals) {
            summaryDuration = summaryDuration.plus(calculateOneDuration(interval));
        }

        Duration averageDuration = Duration.ofSeconds(summaryDuration.getSeconds() / intervals.size());

        return averageDuration.toHours() + "ч " + averageDuration.toMinutesPart() + "м";
    }

    private static Duration calculateOneDuration(String interval) {

        String[] dates = interval.split(" - ");
        Instant[] instants = new Instant[2];

        for (int i = 0; i < dates.length; i++) {
            instants[i] = Instant.parse(toFormat(dates[i]));
        }

        return Duration.between(instants[0], instants[1]);
    }

    private static String toFormat(String dateInTaskFormat) {
        String[] splitted = dateInTaskFormat.split(", ");

        return splitted[0] + "T" + splitted[1] + ":00Z";
    }

}
