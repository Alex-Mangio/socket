package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer extends Thread {

    Socket s;

    ThreadServer(Socket s) {
        this.s = s;
    }

    public void run() {
        boolean loop = true;
        boolean loopThread = true;

        
        
        try {

            System.out.println("un client e' connesso e sta ascoltando");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            while (loop) {

                String stringaRicevuta = in.readLine();

                if (stringaRicevuta.equals("exit")) {
                    loop = false;
                    System.out.println("server terminato");
                } else {
                    System.out.println("La stringa ricevuta e': " + stringaRicevuta);
                    String stringaMaiusc = stringaRicevuta.toUpperCase();
                    out.writeBytes(stringaMaiusc + "\n");
                }
            }
            s.close();
        } catch (Exception e) {
        }
    }
}
