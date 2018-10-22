/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Orlando
 */
public class Muta {
    public static Individuo Muta2puntos(Individuo hijo) {
        int n1 = ThreadLocalRandom.current().nextInt(0,hijo.getGenotipo().length-1);
        int n2 = ThreadLocalRandom.current().nextInt(0,hijo.getGenotipo().length-1);
        for(int i=0;;i++) {
            if(n1==n2) {
                n2 = ThreadLocalRandom.current().nextInt(0,hijo.getGenotipo().length-1);
            } else {
                break;
            }
        }
        
        if(hijo.getGenotipo()[n1]==1) {
            hijo.getGenotipo()[n1]=0;
        } else {
            hijo.getGenotipo()[n1]=1;
        }
        
        if(hijo.getGenotipo()[n2]==1) {
            hijo.getGenotipo()[n2]=0;
        } else {
            hijo.getGenotipo()[n2]=1;
        }
        
        hijo.calcularFitness();
        
        return hijo;
    }
}
