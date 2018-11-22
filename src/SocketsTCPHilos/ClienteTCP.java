/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketsTCPHilos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smonreal
 */
public class ClienteTCP {
    
    private static Socket clientSocket;
    
    public static void main(String[] args) {
	
        String hostName = "127.0.0.1";
	int portNumber = 1234;
	try {
            InetAddress address = InetAddress.getByName(hostName);
            clientSocket = new Socket(address, portNumber);
            System.out.println("ENTER para enviar, Bye. para terminar.\n");
			
            EjecutaCliente l;
            recibirCliente c = null;
            try {
                l = new EjecutaCliente(clientSocket);
                c = new recibirCliente(clientSocket);
                Thread t = new Thread(l);
                t.start();
                Thread t2 = new Thread(c);
                t2.start();
            } catch (Exception e) { System.out.println(e.getMessage()); }
	}
        catch (IOException e) { e.printStackTrace(); }
    }
}
