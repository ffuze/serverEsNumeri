package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
        try {
            System.out.println("Server in avvio...");

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("Client connesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            out.writeBytes("Benvenuto, indovina un numero da 1 a 100" + "\n");

            int n = (int) (Math.random() * 100 + 1);

            int nRicevuto = 0;
            
            do {
                nRicevuto = Integer.parseInt(in.readLine());
                if (nRicevuto < n) 
                    out.writeBytes("1\n");
                else if (nRicevuto > n) 
                    out.writeBytes("2\n");
                else if(nRicevuto == n)
                    out.writeBytes("3\n");
            } while (nRicevuto != 3);

            s.close();
            server.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("C'è stato un errore nella fase di connessione oppure il client si e' disconnesso");
            System.exit(1);
        }

    }
}
