/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class carro {
    public int id;
    public int tipo;
    
    public carro(int id){
        // 0 - Moto
        // 1 - carro
        // 2 - camioneta
      this.tipo = ThreadLocalRandom.current().nextInt(0, 3);
      System.out.println("Se a creado el "+tipo+" Id : "+id);
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "carro { " + "id : " + id + ", tipo : " + tipo + '}';
    }
}
