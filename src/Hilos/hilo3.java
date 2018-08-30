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
public class hilo3 extends Thread {

    public int i=20;
    
    public hilo3(){}
    
    @Override
    public void run() {
        while(true){
           if(i<=30){
               System.out.println("Hilo 3 : "+i);
               i=i+1;
           }
        }
    }
}
