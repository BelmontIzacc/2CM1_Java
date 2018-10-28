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
public class GeneticoV1 {
    private int tamPob;
    private int numGeneraciones;
    private Poblacion pobActual;
    private double probabilidadMuta;
    private double muestra;
    
    private String[] posible;
    
    public GeneticoV1(int tamPob, int numGeneraciones,double p,double muestra) {
        this.tamPob = tamPob;
        this.numGeneraciones = numGeneraciones;
        this.pobActual = new Poblacion(tamPob);
        this.probabilidadMuta = p;
        this.muestra = muestra;
    }
    
    public void evolucionar(){
       Poblacion nuevaPoblacion; 
       //this.pobActual.calcularMayorMenor();
       // agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
          int cantidad = (int)(tamPob*muestra)/100;
          nuevaPoblacion.recibirMuetra(this.pobActual.generarMejores(cantidad));
          for(int i=cantidad;i<this.tamPob;i++){
          
          // seleccionar a una madre y un padre
          Individuo madre = seleccion.seleccionAleatoria(pobActual);
          Individuo padre = seleccion.seleccionAleatoria(pobActual);
          // cruza
          int n = ThreadLocalRandom.current().nextInt(1,101)/100;
          Individuo nuevoi = Cruza.cruzaXOR(madre, padre);
          if(n>this.probabilidadMuta) {
              nuevoi = Muta.Muta2puntos(nuevoi);
          }
          // agregamos el individuo a la nueva poblacion
              nuevaPoblacion.getIndividuos().add(nuevoi);
          }
       // actualizamos la población actual 
       this.pobActual = new Poblacion(nuevaPoblacion);
     
       }

       System.out.println("Mejor: "+this.pobActual.getMayor().getFitness());
       
       
    }

    public void evolucionar(int selec, int muta, int cruza) {
       Poblacion nuevaPoblacion; 
       //this.pobActual.calcularMayorMenor();
       // agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
          int cantidad = (int)(tamPob*muestra)/100;
          nuevaPoblacion.recibirMuetra(this.pobActual.generarMejores(cantidad));
          for(int i=cantidad;i<this.tamPob;i++){
          
              // seleccionar a una madre y un padre
              Individuo madre = null;
              Individuo padre = null;
              switch(selec){
                  case 1: {
                      madre = seleccion.seleccionAleatoria(pobActual);
                      padre = seleccion.seleccionAleatoria(pobActual);
                      break;
                  }
                  case 2: {
                      madre = seleccion.TorneoKL(pobActual);
                      padre = seleccion.TorneoKL(pobActual);
                      break;
                  }
                  case 3: {
                      madre = seleccion.seleccionTorneoMax(pobActual);
                      padre = seleccion.seleccionTorneoMax(pobActual);
                      break;
                  }
              }
          

          // cruza
          int n = ThreadLocalRandom.current().nextInt(1,101)/100;
          Individuo nuevoi =  null;
          switch(cruza){
                  case 1: {
                      nuevoi = Cruza.cruzaBinaria(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,1,1},madre, padre);
                      break;
                  }
                  case 2: {
                      nuevoi = Cruza.cruzaAND(madre, padre);
                      break;
                  }
                  case 3: {
                      nuevoi = Cruza.cruzaOR(madre, padre);
                      break;
                  }
          }
          
          if(n>this.probabilidadMuta) {
              switch(muta){
                  case 1:{
                      nuevoi = Muta.Muta2puntos(nuevoi);
                      break;
                  }
              }
          }
          // agregamos el individuo a la nueva poblacion
              nuevaPoblacion.getIndividuos().add(nuevoi);
          }
       // actualizamos la población actual 
       this.pobActual = new Poblacion(nuevaPoblacion);
     
       }

       System.out.println("Mejor: "+this.pobActual.getMayor().getFitness());
    }

    public Genetico.Poblacion getPobActual() {
        return pobActual;
    }

    
}
