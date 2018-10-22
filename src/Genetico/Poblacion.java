/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import Quine_Mcclu.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class Poblacion {
    private ArrayList<Individuo> individuos;
    private Individuo menor;
    private Individuo mayor;
    
    public Poblacion(){
        this.individuos = new ArrayList<>();
        this.menor = null;
        this.mayor = null;
    }
    // poblacion aleatoria 
    public Poblacion(int t)
    {
        this.individuos = new ArrayList<>();
        for(int x=0;x<t;x++)
        {        
            Individuo i = new Individuo();
            this.individuos.add(i);
        }
        calcularMayorMenor();
     }
    // la creacion de una poblacion en base a otra
    public Poblacion(Poblacion pob){
        this.individuos = new ArrayList<>();
        for (Individuo ind: pob.getIndividuos()){
            ind.getFitness();
           this.individuos.add(new Individuo(ind.getGenotipo()));
           //ind.getFitness();
        }
        calcularMayorMenor();
    }
    public void calcularMayorMenor(){
      // recorrer la población completa 
      this.mayor = new Individuo(this.individuos.get(0).getGenotipo());
      this.menor = new Individuo(this.individuos.get(0).getGenotipo());
      
      for(int x=0; x<this.individuos.size();x++){
          if(this.individuos.get(x).getFitness()
                  >this.mayor.getFitness()){
           this.mayor = new Individuo(this.individuos.get(x).getGenotipo());
          }
           if(this.individuos.get(x).getFitness()
                  <this.menor.getFitness()){
           this.menor = new Individuo(this.individuos.get(x).getGenotipo());
          }
      }
    }
    
   /* public void ordenarQuickSort()
    {
        Ordenamiento.quickSort(individuos);
    }*/
    
    /*generacion tipos de grupos*/
    public ArrayList generarMejores(int t) {
        ArrayList<Individuo> aux = this.individuos;
        Ordenamiento.quickSort(aux);
        ArrayList<Individuo> mejores = new ArrayList<>();
        for(int i=0;i<t;i++) {
            mejores.add(aux.get(i));
        }
        return mejores;
    }
    
    public ArrayList generarPeores(int t) {
        ArrayList<Individuo> aux = this.individuos;
        Ordenamiento.quickSort(aux);
        ArrayList<Individuo> peores = new ArrayList<>();
        int j = aux.size()-1;
        for(int i=0;i<t;i++) {
            peores.add(aux.get(j));
            j--;
        }
        return peores;
    }
    
    public ArrayList generarAleatorio(int t) {
        ArrayList<Individuo> aux = this.individuos;
        Ordenamiento.quickSort(aux);
        ArrayList<Individuo> random = new ArrayList<>();
        for(int i=0;i<t;i++) {
            int exist = 0;
            int j = ThreadLocalRandom.current().nextInt(0,aux.size());
            for(int k=0;k<random.size();k++) {
                try {
                    if(random.get(k).equals(aux.get(j))) {
                        exist=1;
                       break;
                    }
                } catch(Exception e) {
                    
                }
            }
            if(exist==0) {
                random.add(aux.get(j));
            }
        }
        return random;
    }

    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    public Individuo getMenor() {
        return menor;
    }

    public Individuo getMayor() {
        return mayor;
    }

    void recibirMuetra(ArrayList<Individuo> generarMejores) {
        for(int i=0;i<generarMejores.size();i++) {
            this.individuos.add(new Individuo(generarMejores.get(i).getGenotipo()));
        }
        
    }
    
}
