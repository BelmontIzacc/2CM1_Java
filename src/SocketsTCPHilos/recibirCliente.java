/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketsTCPHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author izacc
 */
public class recibirCliente implements Runnable{
    
    private Socket client;

    //Constructor
    recibirCliente(Socket client) {
        this.client = client;
        System.out.println("Cliente");
//        System.out.println("En escucha con: " + client);
    }

    @Override
    public void run() {
        
        BufferedReader in = null;
        PrintWriter out = null;
        try{
          in = new BufferedReader(new InputStreamReader(client.getInputStream()));
          out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
          System.out.println(e.getMessage());
          System.exit(-1);
        }
        
        String line = "";
        int clientPort = client.getPort(); 
        while(line != null){
          try{
            line = in.readLine();
             System.out.println(clientPort + " >> " + line);
           } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
           }
          System.out.print("> ");
        }
    }
    
}
