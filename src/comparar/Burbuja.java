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

public class Burbuja{
    
    private double tiempoInicio;
    private double tiempoFinal;
    private double tiempoTotal;
    private int intercambios;
    private int comparaciones;

    public Burbuja() {
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
        this.tiempoTotal = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    }

    public void ordenar(double []arreglo){
            
        this.tiempoInicio = System.currentTimeMillis();
    
          for(int i = 1; i < arreglo.length; i++)    // 5n(5n(15))= (75n)(5n) = 375n2
            { 
            for(int j = 0; j < arreglo.length - 1; j++)  //5n(15)
                 {
                   this.comparaciones++; //2
                                        //total  = 15
                if (arreglo[j] > arreglo[j + 1])  // 4
                { 
                    double tmp = arreglo[j]; //2
                    arreglo[j] = arreglo[j+1]; //4
                    arreglo[j+1] = tmp; // 3
                    this.intercambios++; //2
                    // intercambios = intercambios +1
                }
            }
        }
          //total = 4n(5n(13n)) = 4n (65n) = 260n^2 = n^2
          this.tiempoFinal = System.currentTimeMillis();
          this.tiempoTotal=tiempoFinal-tiempoInicio;
    
    }
    public double getTiempo_total() {
        return tiempoTotal;
    }
    
    
}
