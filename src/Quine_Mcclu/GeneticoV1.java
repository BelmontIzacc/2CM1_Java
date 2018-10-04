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
public class GeneticoV1 {
    private int tamPob;
    private int numGeneraciones;
    private Poblacion pobActual;
    private ArrayList<elemento> cfinal;
    
    private String[] posible;
    
    public GeneticoV1(int tamPob, int numGeneraciones,ArrayList<elemento> cfinal) {
        this.tamPob = tamPob;
        this.numGeneraciones = numGeneraciones;
        this.cfinal = cfinal;
        this.pobActual = new Poblacion(cfinal);
    }
    
    public void evolucionar(){
       Poblacion nuevaPoblacion; 
       //this.pobActual.calcularMayorMenor();
       // agregar el ciclo para las generaciones 
       for(int g=0; g<this.numGeneraciones;g++){
          // proceso iterativo de construccion de la
          // nueva población
          nuevaPoblacion = new Poblacion();
          for(int i=0;i<this.tamPob;i++){
          
          // seleccionar a una madre y un padre
          Individuo madre = seleccion.seleccionAleatoria(pobActual);
          Individuo padre = seleccion.seleccionAleatoria(pobActual);
          // cruza
          Individuo nuevoi = Cruza.cruza(madre, padre);
          // agregamos el individuo a la nueva poblacion
          nuevaPoblacion.getIndividuos().add(nuevoi);
          }
       // actualizamos la población actual 
       this.pobActual = new Poblacion(nuevaPoblacion);
     
       }
       
       String aux = this.pobActual.getMayor().Genotipo();
       //System.out.println("Mejor: "+this.pobActual.getMayor().getFitness());
       
       calcularSolucion(aux);
    }

    private void calcularSolucion(String aux) {
       System.out.println("Uso Binario -> "+aux);
       String minterminos="";
       for(int x = 0 ; x<aux.length(); x++ ){
           String valor = ""+aux.charAt(x);
           if(valor.equals("1")){
               if(x==0){
                   minterminos=""+x;
               }else{
                   minterminos+=","+x;
               }
           }
       }
       System.out.println("Minterminos seleccionados : "+minterminos);
       this.posible = new String[16];
       
       for(int x = 0 ; x<16;x++){
           this.posible[x] = ""+aux.charAt(x);
       }
       
       String a;
       
       String[] numeros = this.posible.clone();
        //1ª forma: Sin array auxiliar
        for (int i=0; i<8; i++) {
            a = numeros[i];
            numeros[i] = numeros[numeros.length-1-i];
            numeros[numeros.length-1-i] = a;
        }
       
       ArrayList<elemento> s = new ArrayList<>();
       int c=0;
       for(int x = 0 ; x<this.cfinal.size() ;x++){
           String[] pos = this.cfinal.get(x).getPosicionTabla().split(",");
           for(int i = 0 ; i<pos.length ; i++){
               for(int j = 0 ; j<this.posible.length; j++){
                   if(numeros[j].equals("1") && pos[i].equals(""+j)){
                       c++;
                   }
               }
           }
           
           if(c==pos.length){
               s.add(this.cfinal.get(x));
               c=0;
           }else{
               c=0;
           }
       }
       System.out.println("\nElementos seleccionados...");
       System.out.println("\nPosiciones \t\t bits");
       for(int x = 0 ; x<s.size() ; x++){
           System.out.println(""+s.get(x).getPosicionTabla()+"\t\t\t "+s.get(x).Bit());
       }
       
       System.out.println("\nResutado Minimizado : "+interprete.mostrar(s));
       
    }
}
