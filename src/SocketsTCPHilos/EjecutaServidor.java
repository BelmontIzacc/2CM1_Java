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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smonreal
 */
public class EjecutaServidor implements Runnable{
    public Socket client;

    EjecutaServidor(Socket client) {
        this.client = client;
        System.out.println("Conectado a: " + client);
    }

    public void run(){
        
        BufferedReader in = null;
        PrintWriter out = null;
        try{
          in = new BufferedReader(new InputStreamReader(client.getInputStream()));
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
          if (line.contains("Bye.")) {
              try {
                  client.close();
              } catch (IOException ex) {
                  Logger.getLogger(EjecutaServidor.class.getName()).log(Level.SEVERE, null, ex);
              }
                    System.exit(0);
                    break;
                }
            }
            System.out.println("conexion terminada!");
        try {
            client.close();
            System.out.println("conexion con : " + client + " terminada!");
        } catch (IOException e) {
            System.out.println("Error en conexion con el cliente : " + client);
        }
    }
}
