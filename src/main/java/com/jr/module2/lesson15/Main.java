package com.jr.module2.lesson15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void server() {
        final int port = 8080;

        // Create a ServerSocket that listens on the specified port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create BufferedReader and PrintWriter for communication with the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read and echo messages from the client
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received from client: " + inputLine);
                    // Echo the message back to the client
                    out.println("Server: " + inputLine);
                }

                // Close resources for the current client
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void client() {
        final String serverAddress = "localhost"; // 127.0.0.1
        final int serverPort = 8080;

        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + socket);

            // Create BufferedReader for reading from the server and PrintWriter for writing to the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read messages from the console and send them to the server
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                // Send the message to the server
                out.println(userInput);

                // Receive and display the server's response
                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);
            }

            // Close resources
            consoleReader.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
