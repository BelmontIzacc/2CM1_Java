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
 * @author izacc
 */
public class mandarServidor implements Runnable {
    public Socket client;
     
    mandarServidor(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        PrintWriter out =  null;
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.print("> "); 
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.print("> ");
            }
        } catch (IOException ex) {
            Logger.getLogger(mandarServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}
