/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class fabrica extends Thread{
    public int tam;
    public ArrayList<carro> c;
    public int crear;
            
    public fabrica(){
        this.c = new ArrayList<>();
        crear =0;
        // 0 para detenido
        // 1 para crear;
    }

    @Override
    public void run() {
        while(true){
            if(crear==1){
                this.tam = ThreadLocalRandom.current().nextInt(1, 11);
                System.out.println("Cantidad de carros formados : "+tam);
                for(int x = 0 ; x < this.tam ; x++){
                    c.add(new carro(x));
                }
                crear=0;
            }
        }
    }

    public ArrayList<carro> getC() {
        return c;
    }

    public void setC(ArrayList<carro> c) {
        this.c = c;
    }

    public int getCrear() {
        return crear;
    }

    public void setCrear(int crear) {
        this.crear = crear;
    }
}
