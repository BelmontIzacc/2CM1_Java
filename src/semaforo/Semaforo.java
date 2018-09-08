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
    private int estado;
    // verde = 1
    // rojo = 0
    public Semaforo(){
        this.estado=0;
    }

    @Override
    public void run() {
        while(true){
            int aux;
           if(getEstado()==0){
               System.out.println("EN ROJO");
               aux = ThreadLocalRandom.current().nextInt(10,16);
               esperarXsegundos(aux);
               System.out.println("Se cambio a VERDE");
               setEstado(1);
           }else if(getEstado()==1){
               System.out.println("EN VERDE");
               aux = ThreadLocalRandom.current().nextInt(10, 16);
               esperarXsegundos(aux);
               System.out.println("Se cambio a ROJO");
               setEstado(0);
           }
        }
    }
    
    public void esperarXsegundos(int num){
        try {
            Semaforo.sleep(num*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciar(){
        this.setPriority(5);
        this.start();
    }
    
    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
