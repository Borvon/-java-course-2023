package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class Task6 {

    private Task6() {
    }

    public static Map<Integer, Boolean> scanPorts() {
        Map<Integer, Boolean> ports = new HashMap<>();

        final int portsCount = 49151;

        for (int i = 0; i < portsCount; i++) {
            ports.put(i, scanPort(i));
        }
        return ports;
    }

    private static boolean scanPort(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port);
             DatagramSocket datagramSocket = new DatagramSocket(port)) {
            serverSocket.setReuseAddress(true);
            datagramSocket.setReuseAddress(true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
