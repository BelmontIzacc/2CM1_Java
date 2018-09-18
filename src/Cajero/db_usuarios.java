/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cajero;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izacc
 */
public class db_usuarios {
    private ArrayList<usuario> listaUsuarios;

    public db_usuarios() {
        listaUsuarios = new ArrayList<>();
    }
    
    public void addUsuarios(usuario u){
        String noTargeta = ""+ThreadLocalRandom.current().nextInt(4000, 9000);
        for(int x = 0 ; x < this.listaUsuarios.size(); x++){
             if(this.listaUsuarios.get(x).getNumeroTarjeta().equals(noTargeta)){
                 noTargeta = ""+ThreadLocalRandom.current().nextInt(4000, 9000);
                 x=0;
             }else{
                 
             }
        }
        u.setNumeroTarjeta(noTargeta);
        this.listaUsuarios.add(u);
        System.out.println("Se a guardado : "+this.listaUsuarios.get(this.listaUsuarios.size()-1).toString());
    }
    
    public usuario searchUser(String nT){
        usuario u = null;
        for(int x = 0 ; x< this.listaUsuarios.size(); x++){
            if(this.listaUsuarios.get(x).getNumeroTarjeta().equals(nT)){
                u = this.listaUsuarios.get(x);
            }
        }
        return u;
    }
    
    public void operaciones(usuario u, double monto,int movimiento){
        switch(movimiento){
            case 1:{ //suma
                double operacion = u.getFondo() + monto;
                u.setFondo(operacion);
                break;
            }
            case 2:{ //resta
                if(u.getFondo()>monto){
                    double operacion = u.getFondo() - monto;
                    u.setFondo(operacion);
                }else{
                    
                }
                break;
            }
            default :{
                
            }
        }
    }
}
