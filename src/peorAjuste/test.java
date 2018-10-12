/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peorAjuste;

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
        peor p = new peor(16);
        Proceso p1 = new Proceso("A",5);
        Proceso p2 = new Proceso("B",6);
        Proceso p3 = new Proceso("C",2);
        Proceso p4 = new Proceso("D",1);
        Proceso p5 = new Proceso("E",2);
        Proceso p6 = new Proceso("F",2);
        Proceso p7 = new Proceso("G",1);
        Proceso p8 = new Proceso("H",3);
        Proceso p9 = new Proceso("I",3);
        
        p.addProceso(p1);
        
        System.out.println(p.toString());
        
        p.addProceso(p2);
        
        System.out.println(p.toString());
        
        p.addProceso(p3);
        
        System.out.println(p.toString());
        
        p.addProceso(p4);
        
        System.out.println(p.toString());
        
        p.deleteProceso("B");
        
        System.out.println(p.toString());
        
        p.addProceso(p5);
        
        System.out.println(p.toString());
        
        p.addProceso(p6);
        
        System.out.println(p.toString());
        
        p.addProceso(p7);
        
        System.out.println(p.toString());
        
        p.deleteProceso("C");
        
        System.out.println(p.toString());
        
        p.addProceso(p8);
        
        System.out.println(p.toString());
        
        p.addProceso(p9);
        
        System.out.println();
    }
    
}
