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
public class Cruza {                    
    public static Individuo cruzaBinaria(int[] mascara,Individuo madre, Individuo padre)
    {
        String mascare="";
        //verificar los genes de los padres y en base a la mascar crear nuevos genotipos
        //con la premisa que 1 = madre y 0 = padre
        int genotipo1[] = new int[madre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        
        for(int x = 0 ; x < mascara.length ; x++)
        {
            mascare+=" "+mascara[x];
            if(mascara[x]==0)
            {
                genotipo1[x]=padre.getGenotipo()[x];
                genotipo2[x]=madre.getGenotipo()[x];
            }
            else
            {
                genotipo2[x]=padre.getGenotipo()[x];
                genotipo1[x]=madre.getGenotipo()[x];
            }
        }
        //crear los nuevos ind
        Individuo hijo1 = new Individuo(genotipo1);
        Individuo hijo2 = new Individuo(genotipo2);
        System.out.println("Mascara : "+mascare+"\n");
        System.out.println("Hijo 1 Genotipo : "+hijo1.Genotipo()+" Fitness : "+hijo1.getFitness());
        System.out.println("Hijo 2 Genotipo : "+hijo2.Genotipo()+" Fitness : "+hijo2.getFitness());
        
        
        //comprobado el grado de bondad de los 2 hijos
        
        if(hijo1.getFitness()>hijo2.getFitness())
        {
            return hijo1;
        }
        else
        {
            return hijo2;
        }
    }
    
    public static Individuo cruza (Individuo madre, Individuo padre){
        
        int[] gen = new int[madre.getGenotipo().length];
        
        for(int x = 0 ; x < madre.getGenotipo().length ; x++){
            if((madre.getGenotipo()[x]==1) || (padre.getGenotipo()[x]==1)){
                gen[x]=1;
            }else{
                gen[x]=0;
            }
        }  
        Individuo hijo = new Individuo(gen);
        //System.out.println("Hijo 1 Genotipo : "+hijo.Genotipo()+" Fitness : "+hijo.getFitness());
        return hijo;
    }
}
