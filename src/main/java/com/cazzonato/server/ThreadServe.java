package com.cazzonato.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadServe extends Thread {
    Socket socket;
    public ThreadServe(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client connected with thread: ("+this.threadId()+") : "+socket.getInetAddress());
        try {
            // Read client's message
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            System.out.println("Client: " + message);

            Thread.sleep(10000);

            // Closing connections
            bufferedReader.close();
            socket.close();
            System.out.println("Finished client: "+socket.getInetAddress()+" thread: ("+this.threadId()+")");
        } catch (Exception e) {
            System.out.println("Error on the part of the server (thread)");
        }
    }
}
