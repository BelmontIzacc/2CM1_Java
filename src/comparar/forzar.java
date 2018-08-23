/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparar;

import org.jfree.data.xy.XYDataItem;

/**
 *
 * @author izacc
 */
public class forzar {
    private int iteraciones;
    private BubujaOptimizado bo;
    private Burbuja b;
    private QuickSort q;
    private int tam;
    private double[] tiempos;
    private double[] tiempos2;
    private double[] tiempos3;
    
    public forzar(int valor,int tam ,Burbuja b, BubujaOptimizado bo, QuickSort q){
        this.iteraciones = valor;
        this.b = b;
        this.bo = bo;
        this.q = q;
        this.tam = tam;
       
    }
    
    public void comparar(int opc){
        
        Graficar g = new Graficar("Iteracion","Tiempo","Comparacion");
        
        for(int x = 0 ; x<3 ; x++){
            g.agrearSerie("serie "+x);
        }
        
        for(int x = 0 ; x<this.iteraciones ; x++){
            double[] arreglo = new double[tam];
                switch(opc){
                    case 1:{ //mejor
                        arreglo = herramientas.generarDatosOrdenadosAsendendentes(tam);
                        break;
                    }
                    case 2:{ //aleatorio
                        arreglo = herramientas.generarDatosOrdenadosDesendentemente(tam);
                        break;
                    }
                    case 3:{ //peor
                        arreglo = herramientas.datos(tam);
                        break;
                    }
                }
            for(int y = 0 ; y<3 ; y++){
                if(y==0){
                    b.ordenar(arreglo.clone());
                    double tiempo = b.getTiempo_total();
                    g.agregarDatoASerie("serie "+y,new XYDataItem(x, tiempo));
                }else if(y==1){
                    bo.ordenar(arreglo.clone());
                    double tiempo = bo.getTiempo_total();
                    g.agregarDatoASerie("serie "+y,new XYDataItem(x, tiempo));
                }if(y==2){
                    q.ordenar(arreglo.clone());
                    double tiempo = q.getTiempo_total();
                    g.agregarDatoASerie("serie "+y,new XYDataItem(x, tiempo));
                }
            }
        }
        g.crearYmostrarGrafica();
    }
}
