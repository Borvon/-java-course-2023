package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {

    private HackerNews() {
    }

    public static long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request =
                HttpRequest.newBuilder().uri(URI.create("https://hacker-news.firebaseio.com/v0/topstories.json"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String[] topStoriesString = response.body().substring(1, response.body().length() - 1).split(",");
            long[] topStories = new long[topStoriesString.length];
            for (int i = 0; i < topStoriesString.length; i++) {
                topStories[i] = Long.parseLong(topStoriesString[i]);
            }

            return topStories;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String news(long id) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request =
                HttpRequest.newBuilder().uri(URI.create("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Pattern pattern = Pattern.compile("\"title\":\"(.*?)\",");
            Matcher matcher = pattern.matcher(response.body());

            if (matcher.find()) {
                return matcher.group(1);
            }

            return null;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
