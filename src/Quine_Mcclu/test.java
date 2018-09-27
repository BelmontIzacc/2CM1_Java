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
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int min[] = new int[]{1,3,4,5,7,9,10,11,15};
        
        String v1[] = new String[]{"0","0","0","0"};
        String v2[] = new String[]{"0","0","0","1"};
        String v3[] = new String[]{"0","0","1","0"};
        String v4[] = new String[]{"0","0","1","1"};
        String v5[] = new String[]{"0","1","0","0"};
        String v6[] = new String[]{"0","1","1","1"};
        String v7[] = new String[]{"1","0","0","1"};
        String v8[] = new String[]{"1","0","1","0"};
        String v9[] = new String[]{"1","1","0","1"};
        String v10[] = new String[]{"1","1","1","0"};
        String v11[] = new String[]{"1","1","1","1"};
        
        elemento e1 = new elemento(v1,"0");
        elemento e2 = new elemento(v2,"1");
        elemento e3 = new elemento(v3,"2");
        elemento e4 = new elemento(v4,"3");
        elemento e5 = new elemento(v5,"4");
        elemento e6 = new elemento(v6,"7");
        elemento e7 = new elemento(v7,"9");
        elemento e8 = new elemento(v8,"10");
        elemento e9 = new elemento(v9,"13");
        elemento e10 = new elemento(v10,"14");
        elemento e11 = new elemento(v11,"15");
        
        mac m = new mac(min);
        m.agregar(e1);
        m.agregar(e2);
        m.agregar(e3);
        m.agregar(e4);
        m.agregar(e5);
        m.agregar(e6);
        m.agregar(e7);
        m.agregar(e8);
        m.agregar(e9);
        m.agregar(e10);
        m.agregar(e11);
        
        m.agrupacion();
        System.out.println("! -> significa negacion\nEjemplo : A! = A negada\n");
        System.out.println("El resultado final es : "+m.getResultado());
        System.out.println("\n\nFalta la parte de memo para minimizar todo lo posible, ahorita arroja todo el resultado tal cual");
        System.out.println();
        
    }
    
}
