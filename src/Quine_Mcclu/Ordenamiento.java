/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quine_Mcclu;

import java.util.ArrayList;

/**
 *
 * @author izacc
 */
public class Ordenamiento {
    public static void quickSort(ArrayList<Individuo> individuos)
    {
        if (individuos!= null)
        {
         ordenarQuick(individuos,0,individuos.size()-1);
        }
    }
    
    private static void ordenarQuick(ArrayList<Individuo> individuos, int izq, int der) 
    {
        // seleccionar el pivote 
        Individuo pivote = individuos.get(izq);
        // realiza la busqueda de izq a derecha
        int i = izq;
        // realiza la busqueda de derecha a izq
        int j = der;
        Individuo aux;
        
        // mientras no se crucen las busquedas ( i y j)
        while (i<j){
            // buscar elemento mayor al pivote 
            while (individuos.get(i).getFitness()<= pivote.getFitness() && i<j) i++;
            
            // buscar el elemento menor al pivote
            while(individuos.get(j).getFitness()>pivote.getFitness()) j--;
          // si no se han cruzado i y j
          // hacer intercambio
          if (i < j) {
          
            aux = individuos.get(i);
            //individuos.get(i) = individuos.get(j);
            individuos.set(i, individuos.get(j));
            //individuos.get(j) = aux;
            individuos.set(j, aux);
          
          }
        }
        // colocar el pivote en su lugar de forma en que tendremos los menores 
        // a su izquierda y los mayores a su derecha
        //tmpArray[izq] = tmpArray[j];
        individuos.set(izq, individuos.get(j));
        //tmpArray[j] = pivote;
        individuos.set(j, pivote);
        /// ordenar el sub arreglo izq
        if (izq<j-1)
            ordenarQuick(individuos,izq,j-1);
          /// ordenar el sub arreglo der
        if (j+1 < der)
            ordenarQuick(individuos, j+1, der);  
    } 
}
