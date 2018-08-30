/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author izacc
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        hilo h = new hilo();
        hilo2 h2 = new hilo2();
        hilo3 h3 = new hilo3();
        h.start();
        h2.start();
        h3.start();
        
        System.out.println("Holi");
        System.out.println("Clase de java");

    }   
    
}
