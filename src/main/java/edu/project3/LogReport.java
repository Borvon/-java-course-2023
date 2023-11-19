package edu.project3;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LogReport {

    private final Pattern format =
        Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3} - - \\[(.*?)] \"(.*?)\" (\\d{3}) (\\d*) \".*?\" \".*?\"");
    private String name;
    private int requestCount;
    private int averageResponseSize;

    private int summaryResponseSize;
    private Map<String, Integer> resources = new HashMap<>();
    private Map<Integer, Integer> responses = new HashMap<>();

    public static void main(String[] args) {
        new LogReport(
            Paths.get("A:", "java course", "nginx_logs.txt"),
            null,
            null
        );
    }

    public LogReport(Path path, LocalDate from, LocalDate to) {

        name = path.getFileName().toString();

        try (Stream<String> lines = Files.lines(path)) {

            lines.forEach((string) -> {

                Matcher mathcer = format.matcher(string);

                if (mathcer.find()) {
                    String dateString = mathcer.group(2);
                    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                        .appendPattern("dd/MMM/yyyy:HH:mm:ss Z")
                        .toFormatter(Locale.ENGLISH);
                    LocalDate date = LocalDateTime.parse(dateString, formatter).toLocalDate();

                    if ((from == null || !date.isBefore(from)) && (to == null || !date.isAfter(to))) {

                        requestCount++;

                        int response = Integer.parseInt(mathcer.group(4));
                        if (!responses.containsKey(response)) {
                            responses.put(response, 1);
                        } else {
                            responses.put(response, responses.get(response) + 1);
                        }

                        summaryResponseSize += Integer.parseInt(mathcer.group(5));

                        String request = mathcer.group(3).split(" ")[1];

                        Matcher requestMatcher = Pattern.compile("/(?!.*/)(.*)").matcher(request);

                        if (requestMatcher.find()) {
                            String resource = requestMatcher.group(1);

                            if (!resources.containsKey(resource)) {
                                resources.put(resource, 1);
                            } else {
                                resources.put(resource, resources.get(resource) + 1);
                            }
                        }
                    }
                }
            });

            if (requestCount == 0) {
                averageResponseSize = 0;
            } else {
                averageResponseSize = summaryResponseSize / requestCount;
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LogReport(URL url) {
    }

}
