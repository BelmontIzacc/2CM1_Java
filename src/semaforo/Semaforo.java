/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author izacc
 */
public class Semaforo extends Thread{
    public int estado;
    // verde = 1
    // rojo = 0
    public Semaforo(){
        estado=0;
    }

    @Override
    public void run() {
        while(true){
            int aux;
           if(estado==0){
               aux = ThreadLocalRandom.current().nextInt(5,11);
               esperarXsegundos(aux);
               estado=1;
               System.out.println("EN ROJO");
           }else if(estado==1){
               aux = ThreadLocalRandom.current().nextInt(5, 11);
               esperarXsegundos(aux);
               estado=0;
               System.out.println("EN VERDE");
           }
        }
    }
    
    public void esperarXsegundos(int num){
        try {
            this.sleep(num*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getEstado(){
        return estado;
    }
}
