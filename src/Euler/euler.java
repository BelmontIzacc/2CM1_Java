/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import org.jfree.data.xy.XYDataItem;
import org.nfunk.jep.JEP;

/**
 *
 * @author izacc
 */
public class euler {
    
       private String fucion;
       private String xi;
       private String yi;
       private String ho;
       private String elementos;
       private double[] xtabla;
       private double[] ytabla;
       
    public euler(String fucion, String xi, String yi, String ho, String e) {
        this.fucion = fucion;
        this.xi = xi;
        this.yi = yi;
        this.ho = ho;
        this.elementos = e;
    }
    
    public void resolverEuler(){
        JEP funci= new JEP(); //crea e instancia objeto que lee funciones
        funci.addStandardFunctions(); // adiciona las funciones matematicas
        funci.addStandardConstants();// adiciona las constantes matematicas
        funci.setImplicitMul(true); //permite 2x , 3x, xe
        
        double xinicial = Double.parseDouble(this.xi); //optiene el valor de Xo
        int e = Integer.parseInt(this.elementos);
        this.xtabla = new double[e];
        double ho = Double.parseDouble(this.ho);
        
        xtabla[0]=xinicial;
        for(int x = 1 ; x < xtabla.length ; x++){
            xtabla[x]=(xtabla[x-1]+ho);
        }
        
        double yinicial = Double.parseDouble(yi);
        this.ytabla = new double[e];
        this.ytabla[0] = yinicial;
        
        for (int i=1;i<xtabla.length;i++){
            funci.addVariable("x", xtabla[i-1]); //agrega los valores de x para los pasos de tamaño definido
            funci.addVariable("y", ytabla[i-1]);
            funci.addVariable("h", ho);
            String f = "y+(h*("+this.fucion+"))"; //<- formula "euler" -> Yn = Yn-1 + hf(Xn-1,Yn-1)
            funci.parseExpression(f); //se pasa la funcion y se estandarisa
            ytabla[i] = funci.getValue();
        }
        
        
    }

    public String getFucion() {
        return fucion;
    }

    public String getXi() {
        return xi;
    }

    public String getYi() {
        return yi;
    }

    public String getHo() {
        return ho;
    }

    public String getElementos() {
        return elementos;
    }

    public double[] getXtabla() {
        return xtabla;
    }

    public double[] getYtabla() {
        return ytabla;
    }
         
}
