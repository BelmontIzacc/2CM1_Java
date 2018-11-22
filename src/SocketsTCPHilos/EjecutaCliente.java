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
public class EjecutaCliente implements Runnable{
    public Socket client;

    //Constructor
    public EjecutaCliente(Socket client) {
        this.client = client;
        System.out.println("En escucha con: " + client);
    }
@Override
    public void run(){
        BufferedReader in = null;
        try{
          in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
          System.out.println(e.getMessage());
          System.exit(-1);
        }

        String msj = "";
        try {
            PrintWriter out =  new PrintWriter(client.getOutputStream(), true);
			
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.print("> ");
            while ((userInput = stdIn.readLine()) != null) {
		out.println(userInput);
                System.out.print("> ");
                if (userInput.contains("Bye.")) {
                    client.close();
                    System.exit(0);
                    break;
                }
            }
            client.close();
            System.out.println("conexion terminada!");
        } catch (IOException e) { 
            try {
                System.out.println("Conexion terminada con el Servidor");
                client.close();
                System.exit(-1);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.exit(-1);
            }
        }
    }


}
