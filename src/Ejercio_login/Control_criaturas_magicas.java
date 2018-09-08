/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercio_login;

import java.util.ArrayList;

/**
 *
 * @author izacc
 */
public class Control_criaturas_magicas {
    ArrayList<Dobby> dlista;
    
    public Control_criaturas_magicas(){
        dlista = new ArrayList<>();
    }
    
    public void agregar(Dobby d){
        dlista.add(d);
        System.out.println(d.toString());
    }
    public ArrayList<Dobby> getDLista() {
        return dlista;
    }
}
