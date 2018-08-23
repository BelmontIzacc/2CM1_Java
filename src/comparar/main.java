/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparar;

/**
 *
 * @author izacc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Burbuja b = new Burbuja();
        BubujaOptimizado bo = new BubujaOptimizado();
        QuickSort q = new QuickSort();
        
        int iteraciones = 100;
        int tam = 10000;
        
        forzar f = new forzar(iteraciones,tam,b,bo,q);
        f.comparar(3);
        
    }
    
}
