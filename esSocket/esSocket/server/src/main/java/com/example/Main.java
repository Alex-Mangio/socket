package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {

        
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("server partito...");
        
        while(true){
        ThreadServer ts = new ThreadServer(ss.accept());
        ts.start();
        }
        
    }
}