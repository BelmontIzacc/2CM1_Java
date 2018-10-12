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
        
        p.addProceso(p1);
        p.addProceso(p2);
        p.addProceso(p3);
        p.addProceso(p4);
        
        p.deleteProceso("B");
        
        p.addProceso(p5);
        p.addProceso(p6);
        p.addProceso(p7);
        
        p.deleteProceso("C");
        
        p.addProceso(p8);
        
        System.out.println();
    }
    
}
