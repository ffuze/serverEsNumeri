package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

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

            System.out.println("Client connesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            out.writeBytes("Benvenuto, indovina un numero da 1 a 100");

            int n = (int)(Math.random()*100+1);

            int nRicevuto = Integer.parseInt(in.readLine());

            while(nRicevuto != n){
                if(nRicevuto < n)
                    out.writeByte(1 + '\n');
                else
                    out.writeByte(2 + '\n');
            }

            out.writeByte(3 + '\n');

            s.close();
            server.close();
            
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("C'e' stato un errore nella fase di connessione");
            System.exit(1);
        }
    }
}
