/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparar;

import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author izacc
 */
public class herramientas {
    
    public static double[] datos (int tam){
       
       double[] arreglo=new double[tam]; 
       
       for (int x=0;x<tam;x++){
       //arreglo[x] = (int) (Math.random()*max)+1;
       arreglo[x] = ThreadLocalRandom.current().nextInt(0, tam);
       }
       return arreglo;
       //this.datos = arreglo;
   }
   
   public static double[] generarDatosOrdenadosDesendentemente(int n)
   {
       double [] datos = new double[n];
       for(int x = n-1 ; x > -1; x--){
           datos[x] = n - x;
       }
       return datos;
   }
   
   public static double[] generarDatosOrdenadosAsendendentes(int n)
   {
       double [] datos = new double[n];
       for(int x = 1 ; x < n; x++){
           datos[x] = x;
       }
       return datos;
   }
}
