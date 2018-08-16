/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparar;

/**
 *
 * @author izacc
 */
public class forzar {
    private int valor;
    private BubujaOptimizado bo;
    private Burbuja b;
    private QuickSort q;
    private int tam;
    private double[] tiempos;
    private double[] tiempos2;
    private double[] tiempos3;
    private Graficar g;
    public forzar(int valor,int tam ,Burbuja b, BubujaOptimizado bo, QuickSort q){
        this.valor = valor;
        this.b = b;
        this.bo = bo;
        this.q = q;
        this.tam = tam;
        g = new Graficar("Iteracion","Tiempo","Comparacion");
    }
    
    public void comparar(int opc){
        this.tiempos = new double[tam];
        this.tiempos2 = new double[tam];
        this.tiempos3 = new double[tam];
        
        g.agrearSerie("B");
        g.agrearSerie("BO");
        g.agrearSerie("Q");
        
        for(int x = 0 ; x < valor ; x++){
            switch(opc){
                case 1 :{ //mejor
                    b.ordenar(herramientas.generarDatosOrdenadosAsendendentes(tam));
                    tiempos[x]=b.getTiempo_total();
                    bo.ordenar(herramientas.generarDatosOrdenadosAsendendentes(tam));
                    tiempos2[x]=bo.getTiempo_total();
                    q.ordenar(herramientas.generarDatosOrdenadosAsendendentes(tam));
                    tiempos3[x]=q.getTiempo_total();      
                    break;
                }
                case 2 :{ //peor
                    b.ordenar(herramientas.generarDatosOrdenadosDesendentemente(tam));
                    tiempos[x]=b.getTiempo_total();
                    bo.ordenar(herramientas.generarDatosOrdenadosDesendentemente(tam));
                    tiempos2[x]=bo.getTiempo_total();
                    q.ordenar(herramientas.generarDatosOrdenadosDesendentemente(tam));
                    tiempos3[x]=q.getTiempo_total();
                    break;
                }
                case 3 :{ //aleatorio
                    b.ordenar(herramientas.datos(tam));
                    tiempos[x]=b.getTiempo_total();
                    bo.ordenar(herramientas.datos(tam));
                    tiempos2[x]=bo.getTiempo_total();
                    q.ordenar(herramientas.datos(tam));
                    tiempos3[x]=q.getTiempo_total();
                    break;
                }
            }
        }
    }
}
