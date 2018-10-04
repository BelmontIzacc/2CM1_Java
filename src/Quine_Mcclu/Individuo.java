/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quine_Mcclu;

/**
 *
 * @author izacc
 */
public class Individuo {
    private int[] genotipo;
    private int fitness;
    
    public static int[] funcion;
    
    public Individuo(String g){
        this.genotipo = convertirInt(g);
        calcularFitness();
    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo.clone();
        calcularFitness();
    }
    public String Genotipo(){
        String valor="";
        for(int x = this.genotipo.length-1 ; x >=0  ; x--)
        {
            valor+=""+this.genotipo[x];
        }
        return valor;
    }
    
    public void calcularFitness(){
        this.fitness = Integer.parseInt(this.Genotipo(), 2);
    }

    private int[] convertirInt(String g) {
        int[] aux = new int[16];
        String binario;
        String[] pos = g.split(",");
        
        for(int i = 0 ; i < pos.length ; i++){
            for(int x = aux.length-1 ; x>=0 ; x--){
                int posaux = Integer.parseInt(pos[i]);
                if(posaux==x){
                    aux[x]=1;
                }else{
                   if(aux[x]==1){
                       aux[x]=1;
                   }else{
                        aux[x]=0;
                   }
                }
            }
        }
        
        return aux;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }

}
