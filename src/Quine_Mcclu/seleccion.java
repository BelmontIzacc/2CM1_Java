/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quine_Mcclu;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class seleccion {
    public static Individuo seleccionAleatoria(Poblacion p){
        int pos = ThreadLocalRandom.current().nextInt(0, p.getIndividuos().size());
        return p.getIndividuos().get(pos);
    }
    public static Individuo seleccionTorneoMax(Poblacion p){
        p.calcularMayorMenor();
        return p.getMayor();
    }
    public static Individuo TorneoKL(Poblacion p){
        ArrayList<Individuo> aux = p.getIndividuos();
        ArrayList<Individuo> mejores = new ArrayList<>();
        
        Ordenamiento.quickSort(aux);
        
        int tam = ThreadLocalRandom.current().nextInt((p.getIndividuos().size()/2), (p.getIndividuos().size()-1));
        
        for(int x = aux.size()-1; x >= tam ; x--){
            mejores.add(new Individuo(aux.get(x).getGenotipo()));
        }
        
        int pos = ThreadLocalRandom.current().nextInt(0,mejores.size());
        
        return mejores.get(pos);
    }
}
