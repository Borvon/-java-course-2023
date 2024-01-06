package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8880;

    public String run(String key) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(key);

            return reader.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
