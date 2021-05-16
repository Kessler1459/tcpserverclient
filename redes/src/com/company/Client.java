package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client extends Thread {
    private final Socket clientSocket;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Client "+ clientSocket.getInetAddress()+" connected");
            String line;
            List<String> accum=new ArrayList<>();
            while (true) {

                if ((!(line = in.readLine()).equals("x"))){
                    System.out.println(clientSocket.getInetAddress() + " says: " + line);
                    accum.add(line);
                    out.println(accum);
                }
                else {
                    out.println("Bye");
                    break;
                }
            }
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Client "+clientSocket.getInetAddress()+" disconnected");
        }
        catch (Exception ignored) {
        }
    }
}
