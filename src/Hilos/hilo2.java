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
public class hilo2 extends Thread {

    public int i=10;
    
    public hilo2(){}
    
    @Override
    public void run() {
        while(true){
           if(i<=19){
               System.out.println("Hilo 2 : "+i);
               i=i+1;
           }
        }
    }
    
}
