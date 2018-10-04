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
    public Poblacion(ArrayList<elemento> cfinal)
    {
        this.individuos = new ArrayList<>();
        for(int x=0;x<cfinal.size();x++)
        {        
            Individuo i = new Individuo(cfinal.get(x).getPosicionTabla());
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
    
    public void ordenarQuickSort()
    {
        Ordenamiento.quickSort(individuos);
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
    
    
}
