package com.cazzonato.server;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Initialized server...");
            while (true) {
                // Starting ThreadServe
                new ThreadServe(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            System.out.println("Error on the part of the server");
        }
    }
}
