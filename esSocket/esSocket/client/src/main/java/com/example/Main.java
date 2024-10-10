package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        boolean loop = true;

        System.out.println("client partito");
        Socket s = new Socket("localhost",3000);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        while(loop){
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci una stringa");
        out.writeBytes(input.next() + "\n");

        String stringaLetta = in.readLine() ;

        if(stringaLetta.equals("exit")){
            loop = false;
        } else{
            System.out.println("La stringa in maiuscolo:" + stringaLetta);
        }
    };
    System.out.println("client terminato");

        
        
    }
}