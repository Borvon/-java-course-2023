package edu.hw1;

public class Task1 {
    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String videoLength) {
        if (videoLength == null) {
            throw new NullPointerException("Video length cannot be null");
        }

        String[] time = videoLength.split(":");

        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);

        int result;
        if (seconds < 60) {
            result = minutes * 60 + seconds;
        } else {
            result = -1;
        }

        return result;
    }

}
