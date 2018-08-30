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
public class hilo extends Thread {

    public int i=0;
    
    public hilo(){}
    
    @Override
    public void run() {
        while(true){
           if(i<=9){
               System.out.println("Hilo 1 : "+i);
               i=i+1;
           }else{
               break;
           }
        }
    } 
    
}
