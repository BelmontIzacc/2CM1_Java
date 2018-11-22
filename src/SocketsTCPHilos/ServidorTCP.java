/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketsTCPHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smonreal
 */
public class ServidorTCP {

    private static ServerSocket server;
    
    public static void main(String[] args) {
        try{
            server = new ServerSocket(1234);
            System.out.println("Servidor en ejecución...\n");

            while(true){
                EjecutaServidor w = null;
                mandarServidor m = null;
                try {
                    w = new EjecutaServidor(server.accept());
                    m = new mandarServidor(w.client);
                    Thread t = new Thread(w);
                    t.start();
                    Thread t1 = new Thread(m);
                    t1.start();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(-1);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
