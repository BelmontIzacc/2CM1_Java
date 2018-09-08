/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

/**
 *
 * @author izacc
 */
public class correr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semaforo s = new Semaforo();
        fabrica f = new fabrica();
        calle c = new calle(s,f);
        
        s.iniciar();
        c.iniciar();
    }
    
}
