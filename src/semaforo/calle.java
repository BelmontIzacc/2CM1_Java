/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author izacc
 */
public class calle extends Thread{
    public Semaforo s;
    public fabrica f;
    public calle(Semaforo s, fabrica f){
        this.s = s;
        this.f = f;
    }

    @Override
    public void run() {
        while(true){
            if(!f.getC().isEmpty()){
                System.out.println("Esta lleno");
                    boolean sigue = true;
                    while(sigue){
                        if(s.getEstado()==1){
                            System.out.println(f.getC().get(0).toString());
                            int tiempo = 0;
                            switch(f.getC().get(0).getTipo()){
                                case 0:{
                                    //moto
                                    tiempo = 2;
                                    break;
                                }
                                case 1:{
                                    //carro
                                    tiempo = 4;
                                    break;
                                }
                                case 2:{
                                    tiempo = 7;
                                    //camioneta
                                }
                            }
                            esperarXsegundos(tiempo);
                            f.getC().remove(0);
                            if(f.getC().isEmpty()){
                               sigue = false; 
                            }
                        }
                    }
            }else{
                System.out.println("Se crean carros");
                f.setCrear(1);
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
}
