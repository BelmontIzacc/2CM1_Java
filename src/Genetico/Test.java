/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

/**
 *
 * @author Orlando
 */
public class Test {
    public static void main(String args[]) {
        GeneticoV1 p = new GeneticoV1(20,100,0.5,10);
        p.evolucionar();
        System.out.println();
        
    }
}
