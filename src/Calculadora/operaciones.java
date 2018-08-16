/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.util.Random;

/**
 *
 * @author izacc
 */
public class operaciones {
    
    public operaciones(){}
    
    public double suma(double a, double b){
        return (a+b);
    }
    
    public double resta(double a, double b){
        return (a-b);
    }
    
    public double divicion(double a, double b){
        return (a/b);
    }
    
    public double multiplicacion(double a, double b){
        return (a*b);
    }
    
    public double cseno(double s){
        return Math.sin(s);
    }
    public double ccoseno(double c){
        return Math.cos(c);
    }
    public double ctan(double t){
        return Math.tan(t);
    }
    public double potenciac(double p){
        return Math.pow(p, 2);
    }
    public double potencian(double n, double m){
        return Math.pow(n,m);
    }
    
    private double ran(){
       Random r = new Random();
        double n =  r.nextInt(11)+2;
       return n;
    }
    
    public double random(){
       return ran();
    }
}
