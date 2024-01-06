package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 8880;
    private static final int MAX_CONNECTIONS = 5;
    private static final ExecutorService POOL = Executors.newFixedThreadPool(MAX_CONNECTIONS);

    private ServerSocket serverSocket;

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Map<String, String> PHRASES = new HashMap<>();

    static {
        PHRASES.put("личности", "Не переходи на личности там, где их нет");
        PHRASES.put(
            "оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
        );
        PHRASES.put(
            "глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма."
        );
        PHRASES.put("интеллект", "Чем ниже интеллект, тем громче оскорбления");
    }

    public void run() {
        try {

            while (true) {
                Socket clientSocket = serverSocket.accept();

                POOL.execute(() -> {
                    try {
                        BufferedReader reader =
                            new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                        writer.println(PHRASES.get(reader.readLine()));

                    } catch (IOException e) {
                        throw new RuntimeException();
                    }

                });
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
