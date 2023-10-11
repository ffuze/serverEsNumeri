package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try{
            System.out.println("Server in avvio...");

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("C'e' stato un errore nella fase di connessione");
            System.exit(1);
        }
    }
}
