package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    private final String host;
    private final int port;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        this.socket = new Socket(this.host, this.port);
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMessage(String message) {
        this.writer.println(message);
    }

    public String receiveMessage() throws IOException {
        if (this.reader == null) {
            throw new IllegalStateException("SocketClient not connected");
        }
        return this.reader.readLine();
    }

    public void disconnect() throws IOException {
        this.socket.close();
    }

}