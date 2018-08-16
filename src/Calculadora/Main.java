/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

/**
 *
 * @author izacc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        operaciones o = new operaciones();
        int a = 10;
        int b = 5;
        System.out.println("la divicion igual a : "+o.divicion(a, b)+" la multiplicacion igual a : "+o.multiplicacion(a, b));
        System.out.println(o.multiplicacion(a, b));
        System.out.println(""+o.suma(a, b));
        System.out.println(o.resta(a, b));
        System.out.println(o.ccoseno(a));
        System.out.println(o.cseno(a));
        System.out.println(o.ctan(a));
        System.out.println(o.potenciac(b));
        System.out.println(o.potencian(a, b));
        System.out.println(o.random());
        
    }
    
}
