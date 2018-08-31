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
public class fabrica{
    public int tam;
    public ArrayList<carro> c;
    private int crear;
    
    public fabrica(){
        this.c = new ArrayList<>();
        crear =0;
        // 0 para detenido
        // 1 para crear;
    }

    public void rune(){
            if(this.getCrear()==1){
                System.out.println(""+this.getCrear());
                this.tam = ThreadLocalRandom.current().nextInt(3, 11);
                System.out.println("Cantidad de carros formados : "+tam);
                for(int x = 0 ; x < this.tam ; x++){
                    c.add(new carro(x));
                }
                setCrear(0);
            }
    }
    
    public ArrayList<carro> getC() {
        return c;
    }

    public void setC(ArrayList<carro> c) {
        this.c = c;
    }

    

    public void setCrear(int crear) {
        System.out.println(""+crear);
        this.crear = crear;
    }

    /**
     * @return the crear
     */
    public int getCrear() {
        return crear;
    }
}
