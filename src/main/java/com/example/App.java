package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            do {
                ServerSocket server = new ServerSocket(3000);
                Socket s = server.accept();
                MioThread t = new MioThread(s);
            } while (true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la creazione del server");
            System.exit(1);
        }
    }
}
